package com.example.recommendation_agent.interfaces.controller;

import com.example.recommendation_agent.application.RecAgent;
import dev.langchain4j.service.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecAgentController {
    
    private final RecAgent recAgent;

    public RecAgentController(RecAgent recAgent) {
        this.recAgent = recAgent;
    }

    @GetMapping("/recommend-result")
    public String getRecommendation(@RequestParam String sessionId, @RequestParam String userMessage) {
        Result<String> result = recAgent.answer(sessionId, userMessage);
        return result.content();    }
}