package com.example.warehost.domain.model.valueobjects;

import jakarta.persistence.*;

@Embeddable
public class ItemDate {
    // format ddmmyyyy
    private String orderDate;

    public ItemDate() {}

    public ItemDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String toString() {
        return this.orderDate;
    }
}
