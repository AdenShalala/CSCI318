package com.example.warehost.domain.model.valueobjects;

import jakarta.persistence.*;

@Embeddable
public class ItemQuantity {
    int quantity;

    public ItemQuantity(){}

    public ItemQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityInt() {return quantity;}
    public void setQuantityInt(int quantity) {this.quantity = quantity;}

    public String toString() {
        String quantity_str = String.valueOf(quantity);
        return quantity_str;
    }
}
