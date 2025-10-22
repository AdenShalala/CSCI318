package com.example.warehost.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemID implements Serializable {

    @Column(name="ItemID")
    private String itemID;

    public ItemID(){}

    public ItemID(String ItemID){this.itemID = ItemID;}

    public String getItemID(){return this.itemID;}

    public String toString() {
        return this.itemID;
    }
}   
