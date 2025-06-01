package org.example.config;


import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.VectorStoreChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.function.Function;

@Configuration
public class MyAdvisor {


    @Bean
    public  ChatMemory chatMemory(JdbcChatMemoryRepository jdbcChatMemoryRepository) {
        return  MessageWindowChatMemory.builder()
                .chatMemoryRepository(jdbcChatMemoryRepository)
                .maxMessages(10)
                .build();
    }


//    todo 关于缓存的顾问，在实际应用中都需要设计id来区分身份。此处由于是测试，暂时写死
    @Bean
    public MessageChatMemoryAdvisor  messageChatMemory(ChatMemory chatMemory) {

       return  MessageChatMemoryAdvisor.builder(chatMemory)
               .conversationId("1")
                .build();
    }

    @Bean
    public PromptChatMemoryAdvisor promptChatMemoryAdvisor(ChatMemory chatMemory){
        return PromptChatMemoryAdvisor.builder(chatMemory)
                .conversationId("2")
                .build();
    }




//    @Bean
//    public VectorStoreChatMemoryAdvisor  vectorStoreChatMemoryAdvisor(VectorStore vectorStore){
////       todo 从向量数据库中查找相似的问题，然后将其拼接到提示词当中。 对接完vectorstore后待仔细阅读，
//        return VectorStoreChatMemoryAdvisor.builder(vectorStore)
//                .conversationId("3")
//                .build();
//    }




    @Bean
    public SimpleLoggerAdvisor loggerAdvisor(){
       return SimpleLoggerAdvisor.builder()
               .order(Integer.MIN_VALUE)
                .requestToString(new Function<ChatClientRequest, String>() {
                    @Override
                    public String apply(ChatClientRequest chatClientRequest) {

                        return  chatClientRequest.prompt().getContents();
                    }
                })
                .responseToString(new Function<ChatResponse, String>() {
                    @Override
                    public String apply(ChatResponse chatResponse) {

                        Generation result = chatResponse.getResult();
                        return  result.getOutput().getText();
                    }
                })
                .build();
    }


    @Bean
    public SafeGuardAdvisor safeGuardAdvisor(){


       return SafeGuardAdvisor.builder()
                .order(Integer.MIN_VALUE)
                .failureResponse("检测到违规词汇")
                 .sensitiveWords(List.of("色情", "暴恐"))
                .build();
    }



}
