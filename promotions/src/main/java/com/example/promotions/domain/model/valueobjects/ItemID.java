package com.example.promotions.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ItemID {
    @Column(name="itemID")
    private String itemID;

    public ItemID(){}

    public ItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemID(){return this.itemID;}
    public void setItemID(String itemID){this.itemID = itemID;}
}
