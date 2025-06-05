package org.example.services;

import jakarta.annotation.Resource;
import org.springframework.ai.document.Document;
import org.springframework.ai.model.transformer.KeywordMetadataEnricher;
import org.springframework.ai.model.transformer.SummaryMetadataEnricher;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocmentSplit {

    @Resource
    private VectorStore pgVectorStore;

    @Autowired
    private TokenTextSplitter tokenTextSplitter;

    @Autowired
    private KeywordMetadataEnricher keywordMetadataEnricher;

    @Autowired
    private SummaryMetadataEnricher summaryMetadataEnricher;

    public List<Document> documentCollection(List<Document> old, String knowledge) throws IOException {
        ArrayList<Document> list = new ArrayList<>(old);

        List<Document> split = tokenTextSplitter.split(list);

        list.addAll(split);


        /**
         * 对于2和3来说，他们不会产生新的文本Document,仅仅是填充元数据字段
         * */
//        2,关键词填充
        keywordMetadataEnricher.apply(list);


//        3,上下文感知丰富器，
        summaryMetadataEnricher.apply(list);


        list.forEach(token->{ token.getMetadata().put("knowledge", knowledge);});

//        3,上传
        UploadVector(list);
        return list;
    }

    public List<Document>   documentCollection(String message,String knowledge) throws IOException {
        //        1, docment提取
        List<Document> list=new ArrayList<>();
        Document document = new Document(message);
        list.add(document);

        return    documentCollection(list,knowledge);
    }

    private   void UploadVector(List<Document>  list){
        pgVectorStore.accept(list);
    }


}