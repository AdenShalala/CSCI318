package com.example.promotions.interfaces.rest.dto;

public record Recommendation(
    int id,
    String title,
    String description,
    String confidence,
    String impact,
    String icon,
    String color,
    String action) {
}
