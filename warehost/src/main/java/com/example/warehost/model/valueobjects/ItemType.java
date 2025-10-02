package com.example.warehost.model.valueobjects;

import jakarta.persistence.*;

@Embeddable
public class ItemType {
    String type;

    public ItemType(){}

    public ItemType(String type) {
        this.type = type;
    }
}
