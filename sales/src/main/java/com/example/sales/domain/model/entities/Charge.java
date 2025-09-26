package com.example.sales.domain.model.entities;

import java.util.List;

import com.example.sales.domain.model.valueobjects.Price;
import com.example.sales.domain.model.valueobjects.Tag;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Embeddable
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long chargeID;
    @Embedded
    private String type;
    @ElementCollection
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "chargeID"))
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
