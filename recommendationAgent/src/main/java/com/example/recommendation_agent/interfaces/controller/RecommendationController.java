package com.example.recommendation_agent.interfaces.controller;

import com.example.recommendation_agent.application.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {
    
    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommend-chat")
    public String getRecommendation(@RequestParam String sessionId, @RequestParam String userMessage) {
        return this.recommendationService.recommend(sessionId, userMessage);
    }
}
