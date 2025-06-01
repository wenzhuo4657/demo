package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.mcp.SyncMcpToolCallback;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class MyMcpClient {
    private static final AtomicReference<McpSyncClient> clientRef = new AtomicReference<>();

    public static  SyncMcpToolCallback[]   tools;

    public  MyMcpClient(){
        String zhipuaiApiKey = System.getenv("ZHIPUAI_API_KEY");
        McpClientTransport  transport= HttpClientSseClientTransport.
                builder("https://open.bigmodel.cn")
                .sseEndpoint("/api/mcp/web_search/sse?Authorization="+zhipuaiApiKey)
                .objectMapper(new ObjectMapper()).build();
        McpSyncClient client = client(transport, spec -> spec.clientInfo(new McpSchema.Implementation("zhipuclient", "1.0")));
        client.initialize();//初始化
        client.setLoggingLevel(McpSchema.LoggingLevel.DEBUG);



//        1,获取工具列表
       tools=client.listTools(null)
                .tools()
                .stream()
                .map(tool -> {
                    return new SyncMcpToolCallback(client, tool);
                }).toArray(SyncMcpToolCallback[]::new);


//        2，获取提示列表
////        todo mcp的模板字符串应该如何利用？这里似乎可以不支持，但是api层面无法提前得治
//        List<McpSchema.Prompt> prompts = client.listPrompts().prompts();


    }
    private static McpSyncClient client(McpClientTransport transport, Function<McpClient.SyncSpec, McpClient.SyncSpec> customizer) {
        McpClient.SyncSpec syncSpec = McpClient.sync(transport)
                .requestTimeout(Duration.ofSeconds(1000))
                .loggingConsumer(notification -> {//日志消费者
                    System.out.println("Received log message: " + notification.data());
                })
                .capabilities(   //客户端功能配置，核心对象为： McpSchema.ClientCapabilities
                        McpSchema.ClientCapabilities.builder().
                                roots(false).//不允许动态更新资源访问边界
                                sampling(). //允许mcpserver 使用llm，并采样
                                experimental(new HashMap<>()).//疑似自定义功能扩展定义
                                build())
                .clientInfo(new McpSchema.Implementation("client", "1.0"));//客户端版本信息，
        //        以上信息的定义主要用于和mcp服务端进行交互



        McpClient.SyncSpec apply = customizer.apply(syncSpec);
        clientRef.set(
                apply.build()
        );



        return clientRef.get();
    }
}
