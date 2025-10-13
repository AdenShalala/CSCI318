package com.example.warehost.domain.model.valueobjects;

import jakarta.persistence.*;

@Embeddable
public class ItemType {
    String type;

    public ItemType(){}

    public ItemType(String type) {
        this.type = type;
    }
}
