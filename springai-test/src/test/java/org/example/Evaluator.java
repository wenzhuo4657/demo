package org.example;


import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.evaluation.RelevancyEvaluator;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.evaluation.EvaluationRequest;
import org.springframework.ai.evaluation.EvaluationResponse;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 评估rag回答的质量
 */
@SpringBootTest
public class Evaluator {

    @Autowired
    private VectorStore pgVectorStore;

    @Autowired
     private ZhiPuAiChatModel chatModel;
    @Test
    void evaluateRelevancy() {
        String question = "如何理解傻子?";

        RetrievalAugmentationAdvisor ragAdvisor = RetrievalAugmentationAdvisor.builder()
                .documentRetriever(VectorStoreDocumentRetriever.builder()
                        .vectorStore(pgVectorStore)
                        .build())
                .build();

        ChatResponse chatResponse = ChatClient.builder(chatModel).build()
                .prompt(question)
                .advisors(ragAdvisor)
                .call()
                .chatResponse();

        EvaluationRequest evaluationRequest = new EvaluationRequest(
                // The original user question
                question,
                // The retrieved context from the RAG flow
                chatResponse.getMetadata().get(RetrievalAugmentationAdvisor.DOCUMENT_CONTEXT),
                // The AI model's response
                chatResponse.getResult().getOutput().getText()
        );

        RelevancyEvaluator evaluator = new RelevancyEvaluator(ChatClient.builder(chatModel));

        EvaluationResponse evaluationResponse = evaluator.evaluate(evaluationRequest);

        assertThat(evaluationResponse.isPass()).isTrue();
    }
}
