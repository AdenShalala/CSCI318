package com.example.warehost.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehost.service.UserSupportAgent;

import dev.langchain4j.service.Result;

@RestController
public class UserSupportAgentController {
    private final UserSupportAgent userSupportAgent;

    public UserSupportAgentController(UserSupportAgent userSupportAgent) {
        this.userSupportAgent = userSupportAgent;
    }

    @GetMapping("/userSupportAgent")
    public String customerSupportAgent(@RequestParam String sessionId, @RequestParam String userMessage) {
        Result<String> result = userSupportAgent.answer(sessionId, userMessage);
        return result.content();
    }
}
