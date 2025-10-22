package com.example.promotions.interfaces.rest.dto;

public record Insight(
    int id,
    String title,
    String value,
    String subtext,
    String footer,
    String icon,
    String color) {
}
