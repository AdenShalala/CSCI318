package com.example.warehost.controller;

@RestController
public class UserSupportAgentController {

    private final UserSupportAgent userSupportAgent;

    public UserSupportAgentController(userSupportAgent userSupportAgent) {
        this.userSupportAgent = userSupportAgent;
    }

    @GetMapping("/UserSupportAgent")
    public String customerSupportAgent(@RequestParam String sessionId, @RequestParam String userMessage) {
        Result<String> result = customerSupportAgent.answer(sessionId, userMessage);
        return result.content();
    }
    
}
