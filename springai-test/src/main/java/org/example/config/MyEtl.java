package org.example.config;


import org.springframework.ai.model.transformer.KeywordMetadataEnricher;
import org.springframework.ai.model.transformer.SummaryMetadataEnricher;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.filter.Filter;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.ai.zhipuai.ZhiPuAiEmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MyEtl {
    /**
     *  @author:wenzhuo4657
    des: PGVector的文档检索
     */
    @Bean("pgDocumentRetriever")
    public VectorStoreDocumentRetriever documentRetriever(PgVectorStore pgVectorStore){
        return VectorStoreDocumentRetriever.builder().vectorStore(pgVectorStore)
                .similarityThreshold(0.5)
                .filterExpression(new Filter.Expression(Filter.ExpressionType.EQ,new Filter.Key("knowledge"),new Filter.Value("test")))
                .build();
    }

    /**
     * @author:wenzhuo4657 des: 文本分割器
     */
    @Bean
    public TokenTextSplitter tokenTextSplitter() {
        TokenTextSplitter tokenTextSplitter = new TokenTextSplitter();
        return tokenTextSplitter;
    }

    /**
     * 关键词摘要
     */
    @Bean
    public KeywordMetadataEnricher keywordMetadataEnricher(ZhiPuAiChatModel chatModel) {
        KeywordMetadataEnricher keywordMetadataEnricher = new KeywordMetadataEnricher(chatModel, 5);
        return keywordMetadataEnricher;
    }    /**
     *  摘要元数据丰富器
     */
    @Bean
    public SummaryMetadataEnricher summaryMetadata(ZhiPuAiChatModel aiClient) {
        return new SummaryMetadataEnricher(aiClient,
                List.of(SummaryMetadataEnricher.SummaryType.PREVIOUS, SummaryMetadataEnricher.SummaryType.CURRENT, SummaryMetadataEnricher.SummaryType.NEXT));
    }
}
