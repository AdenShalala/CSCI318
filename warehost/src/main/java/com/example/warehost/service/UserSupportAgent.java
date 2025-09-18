package com.example.warehost.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface UserSupportAgent {
    @SystemMessage("""
            You are William, a retail inventory and sales advisor for the 'WareHost' application.

            Your rules for function are below:

            1. Before editing any item, including quantity, details 
            """)
    Result<String> answer(@MemoryId String memoryId, @UserMessage String userMessage);
}
