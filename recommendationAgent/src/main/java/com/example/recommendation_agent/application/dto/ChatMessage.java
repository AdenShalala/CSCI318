package com.example.recommendation_agent.application.dto;

public record ChatMessage(State state, String messageToCustomer, String recommendedItems) {}
