package com.example.sales.domain.model.entities;

import java.util.List;

import com.example.sales.domain.model.valueobjects.Price;
import com.example.sales.domain.model.valueobjects.Tag;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Charge {
    @Embedded
    private String type;
    @Embedded
    private List<Tag> tags;
    @Embedded
    private Price price;
    
    public Charge(){};
    public Charge(String type, List<Tag> tags, Price price) {
        this.type = type;
        this.tags = tags;
        this.price = price;
    }
}
