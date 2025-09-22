package com.example.warehost.model.aggregates;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.example.warehost.model.valueobjects.*;
import com.example.warehost.model.aggregates.ItemId;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ItemId itemId;
    @Embedded
    private ItemType type;
    @Embedded
    private ItemDescription description;
    @Embedded
    private ItemDate order_date;

    public Item() {}

    public Item(ItemId id, String type, String description, LocalDate order_date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.order_date = order_date;
    }
}
