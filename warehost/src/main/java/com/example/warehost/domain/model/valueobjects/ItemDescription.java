package com.example.warehost.domain.model.valueobjects;

import jakarta.persistence.*;

@Embeddable
public class ItemDescription {
    String description;

    public ItemDescription(){}

    public ItemDescription(String description) {
        this.description = description;
    }
    public String toString() {
        return this.description;
    }
}
