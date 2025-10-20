package com.example.recommendation_agent.application;

import com.example.recommendation_agent.application.dto.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    private static final Logger log = LoggerFactory.getLogger(RecommendationService.class);

    private final ChatAgent chatAgent;
    private final RecAgent recAgent;

    public RecommendationService(ChatAgent chatAgent, RecAgent recAgent) {
        this.chatAgent = chatAgent;
        this.recAgent = recAgent;
    }

    public String recommend(String sessionId, String message) {
        try {
            log.info("Session [{}]: User message: {}", sessionId, message);

            ChatMessage chatMessage = this.chatAgent.chat(sessionId, message).content();
            log.info("Session [{}]: Chat agent response: {}", sessionId, chatMessage);

            switch (chatMessage.state()) {
                case CHAT -> {
                    return chatMessage.messageToCustomer();
                }
                case REC -> {
                    String itemTypes = chatMessage.recommendedItems();
                    log.info("Session [{}]: agent item types: {}", sessionId, itemTypes);
                    String recommendation = this.recAgent.answer(sessionId, itemTypes).content();
                    log.info("Session [{}]: agent recommendation: {}", sessionId, recommendation);
                    return recommendation;
                }
                default -> {
                    log.error("Session [{}]: Unknown state from chat agent: {}", sessionId, chatMessage.state());
                    return "I'm sorry, but I'm having trouble processing your request right now. Please try again later.";
                }
            }
        } catch (Exception e) {
            log.error("Session [{}]: Error during recommendation process", sessionId, e);
            return "I'm sorry, but I'm having trouble processing your request right now. Please try again later.";
        }
    }
}