package org.example.config;


import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.ai.zhipuai.ZhiPuAiEmbeddingModel;
import org.springframework.ai.zhipuai.api.ZhiPuAiApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.springframework.ai.vectorstore.pgvector.PgVectorStore.PgDistanceType.COSINE_DISTANCE;
import static org.springframework.ai.vectorstore.pgvector.PgVectorStore.PgIndexType.NONE;

@Configuration
public class MyVectorStore {


    @Bean
    public DataSource myDataSource(){
        DataSource root = DataSourceBuilder.create()
                .url("jdbc:postgresql://117.72.36.124:5432/spring-ai?currentSchema=public")
                .username("postgres")
                .password("postgres")
                .build();
        return root;
    }


    @Bean
    public VectorStore vectorStore(@Qualifier ("myDataSource") DataSource myDataSource, ZhiPuAiEmbeddingModel embeddingModel) {
         JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource);
        return PgVectorStore.builder(jdbcTemplate, embeddingModel)
                .dimensions(2048)                    // Optional: defaults to model dimensions or 1536
                .distanceType(COSINE_DISTANCE)       // Optional: defaults to COSINE_DISTANCE
                .indexType(NONE)                     // Optional: defaults to HNSW
                .initializeSchema(true)              // Optional: defaults to false
                .schemaName("public")                // Optional: defaults to "public"
                .vectorTableName("vector_store")     // Optional: defaults to "vector_store"
                .maxDocumentBatchSize(10000)         // Optional: defaults to 10000
                .vectorTableValidationsEnabled(true)
                .build();
    }
}
