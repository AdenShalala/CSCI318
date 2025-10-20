package com.example.recommendation_agent.infrastructure.agentic;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.allminilml6v2.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocument;

@Configuration
public class AgentConfiguration {
    
    private static final Logger log = LoggerFactory.getLogger(AgentConfiguration.class)

    // provides chat history for agent
    // allocates memory to store previous messages (up to 10)
    @Bean
    ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory.builder() // {
        .id(memoryId)
        .maxMessages(10)
        .build();                                            // }
    }

    @Bean
    EmbeddingModel embeddingModel() {
        return new AllMiniLmL6V2EmbeddingModel();
    }

    // Creates store to keep a provided document's segments
    // used for responding to messages
    @Bean
    EmbeddingStore<TextSegment> embeddingStore(EmbeddingModel embeddingModel, ResourceLoader resourceLoader) throws IOException {

        EmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();

        Resource resource = resourceLoader.getResource(""); // ADD RESOURCE OF ITEMS
        Document document = loadDocument(resource.getFile().toPath(), new TextDocumentParser());

        String[] lines = document.text().split("\r?\n");
        List<TextSegment> segments = Arrays.stream(lines) // {
        .filter(line -> !line.trim()
        .isEmpty()).map(TextSegment::from)
        .collect(Collectors.toList());                    // }

        List<Embedding> embeddings = embeddingModel.embedAll(segments).content();
        embeddingStore.addAll(embeddings, segments);

        log.info("(#) Embedding store built with {} entries.", segments.size());

        return embeddingStore;
    }

    // fetches relevant segments from store for answering queries
    @Bean
    ContentRetriever contentRetriever(EmbeddingStore<TextSegment> embeddingStore, EmbeddingModel embeddingModel) {
        // apparently these parameters need to be tuned depending on embedding model
        // and data but i will leave this here for now

        int max_results = 10;
        double min_score = 0.6; // this is a minimum similarity score
                                // higher = Stricter (few precise results)
                                // lower = More recall (many imprecise results)

        return EmbeddingStoreContentRetriever.builder() // {
        .embeddingStore(embeddingStore)
        .embeddingModel(embeddingModel)
        .maxResults(max_results)
        .minScore(min_score)
        .build();                                       // }
    }

    // need to add the agents from application
    // Links service interfaces with LLM components
    // EXAMPLE
    // @Bean
    // RAGAgent bookRecommendationAgent(ChatModel chatModel, // chosen LLM
    //                                  ContentRetriever contentRetriever, // does it need content from store
    //                                  ChatMemoryProvider chatMemoryProvider) { // conversation history
    //     return AiServices.builder(RAGAgent.class) 
    //             .chatModel(chatModel)
    //             .contentRetriever(contentRetriever)
    //             .chatMemoryProvider(chatMemoryProvider)
    //             .build();
    // }
}

