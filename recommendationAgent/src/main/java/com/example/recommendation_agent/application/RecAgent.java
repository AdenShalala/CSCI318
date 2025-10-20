package com.example.recommendation_agent.application;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface RecAgent {
    @SystemMessage
    ("""
    You are a helpful item recommendation assistant

    You will be provided a list of item types a user wishes to stock in their shop. 
    As well as this, you are provided with a catalog of items of a range of different types.

    Provide a list of 8 to 10 recommended items in the 'recommendedItems' field, choosing the most appropriate items to assist the user.
    Follow this template for each item:
    =====
    Name: <item name>
    Type: <item type>
    Description: <item description>

    If no assistance can be provided, respond with “I'm sorry, no recommended items were found.”

    """)
    Result<String> answer(@MemoryId String memoryId, @UserMessage String userMessage);
}
