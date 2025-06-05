package org.example.controller;

import jakarta.annotation.Resource;
import org.example.config.MyMcpClient;
import org.example.constant.ConstantPrompt;
import org.example.services.DocmentSplit;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.chat.messages.MessageType;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;

import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.filter.Filter;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@RestController
public class ChatController {


    private final ChatClient client;


    @Autowired
    private DocmentSplit docmentSplit;


    @Resource
    private VectorStore vectorStore;



    @Autowired
    public ChatController(ZhiPuAiChatModel zhipuchatModel,
//                          OpenAiChatModel openAiChatModel,
                          MessageChatMemoryAdvisor messageChatMemoryAdvisor,
                          PromptChatMemoryAdvisor promptChatMemoryAdvisor,
                          SimpleLoggerAdvisor loggerAdvisor,
                          SafeGuardAdvisor  safeGuardAdvisor
                                                    ) {
        this.client = ChatClient
                .builder(zhipuchatModel)
//                .defaultSystem(ConstantPrompt.MAONIANG)
                .defaultAdvisors(List.of(
//                        messageChatMemoryAdvisor,
//                        promptChatMemoryAdvisor,
                        loggerAdvisor,
                        safeGuardAdvisor))
                .defaultToolCallbacks(MyMcpClient.tools)
                .build();

    }


    /**
     *  对话
     */
    @GetMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {



        return Map.of("generation", this.client.prompt(message).call().content());
    }

    @GetMapping("/ai/generateStream")
	public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        var prompt = new Prompt(new UserMessage(message));
        return this.client.prompt(message).stream().chatResponse();
    }

    String rag="test";

/**
 *   上传矢量文本
 */
@RequestMapping(method = RequestMethod.POST, value = "/saveEmbeding")
public boolean saveEmbeding(@RequestParam(value = "message") String message) throws IOException {
    docmentSplit.documentCollection(message, rag);
    return true;
}



    /**
     *  知识库对话
     */
    @RequestMapping(method = RequestMethod.GET, value = "/call")
    public  String call(@RequestParam(value = "message") String message) {
        return client.prompt()
                .user(message)
                .advisors(
                        QuestionAnswerAdvisor.builder(vectorStore)
                        .searchRequest(
                                SearchRequest.builder()
                                        .similarityThreshold(0.5)
                                        .filterExpression(new Filter.Expression(Filter.ExpressionType.EQ,new Filter.Key("knowledge"),new Filter.Value(rag)))
                                        .build()
                        ).build()
                )
                .call()
                .content();
    }






}