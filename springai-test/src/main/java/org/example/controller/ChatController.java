package org.example.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@RestController
public class ChatController {


    private final ChatClient client;




    @Autowired
    public ChatController(ZhiPuAiChatModel chatModel,
                          MessageChatMemoryAdvisor messageChatMemoryAdvisor,
                          PromptChatMemoryAdvisor promptChatMemoryAdvisor,
                          SimpleLoggerAdvisor loggerAdvisor,
                          SafeGuardAdvisor  safeGuardAdvisor
                                                    ) {
        this.client = ChatClient.builder(chatModel)
                .defaultAdvisors(List.of(
                        messageChatMemoryAdvisor,
                        promptChatMemoryAdvisor,
                        loggerAdvisor,
                        safeGuardAdvisor))
                .build();

    }

    @GetMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", this.client.prompt(message).call().content());
    }

    @GetMapping("/ai/generateStream")
	public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        var prompt = new Prompt(new UserMessage(message));
        return this.client.prompt(message).stream().chatResponse();
    }
}