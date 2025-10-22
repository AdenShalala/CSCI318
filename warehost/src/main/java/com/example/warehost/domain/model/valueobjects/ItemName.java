package com.example.warehost.domain.model.valueobjects;

import jakarta.persistence.*;

@Embeddable
public class ItemName {
    String name;

    public ItemName(){}

    public ItemName(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String toString() {
        return this.name;
    }
}

