package com.example.warehost.model.valueobjects;

import jakarta.persistence.*;

@Embeddable
public class ItemDescription {
    String description;

    public ItemDescription(){}

    public ItemDescription(String description) {
        this.description = description;
    }
}
