package com.example.recommendation_agent.interfaces.websocket;

import com.example.recommendation_agent.application.RecommendationService;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ChatWebSocketHandler implements WebSocketHandler {
    
    private final RecommendationService recommendationService;

    public ChatWebSocketHandler(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        String sessionID = session.getId();

        return session.send(
            session.receive()
            .map(WebSocketMessage::getPayloadAsText)
            .map(text -> {
                String reply = recommendationService.recommend(sessionID, text);
                return session.textMessage(reply);
            })
        );
    }
}
