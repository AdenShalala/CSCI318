package com.example.warehost.model.valueobjects;

import jakarta.persistence.*;
import java.util.Date;

@Embeddable
public class ItemDate {
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    public ItemDate() {}

    public ItemDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
