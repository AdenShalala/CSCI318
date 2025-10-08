package com.example.sales.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Price {
    @Column(name="price")
    private double price;

    public Price(){}
    public Price(double price){this.price = price;}
    public double getPrice(){return this.price;}
    public void setPrice(double price){this.price = price;}
    
}
