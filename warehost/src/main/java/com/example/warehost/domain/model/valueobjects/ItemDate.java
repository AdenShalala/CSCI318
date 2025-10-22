package com.example.warehost.domain.model.valueobjects;

import jakarta.persistence.*;

@Embeddable
public class ItemDate {
    // format ddmmyyyy
    private String itemDate;

    public ItemDate() {}

    public ItemDate(String itemDate) {
        this.itemDate = itemDate;
    }
    public String toString() {
        return this.itemDate;
    }
}
