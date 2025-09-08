package com.example.warehost.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Item {
    @Id
    private String id;
    private String type;
    private String description;
    private LocalDate order_date;

    public Item() {
    }

    public Item(String id, String type, String description, LocalDate order_date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.order_date = order_date;
    }
}
