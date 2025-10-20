package com.example.recommendation_agent.interfaces.websocket;

import recommendation_agent.demo.service.RecommendationService;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ChatWebSocketHandler implements WebSocketHandler {
    
    private final RecommendationService recommendationService;
}
