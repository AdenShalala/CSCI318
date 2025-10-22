package com.example.warehost.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemID implements Serializable {

    @Column(name="ItemID")
    private String ItemID;

    public ItemID(){}

    public ItemID(String ItemID){this.ItemID = ItemID;}

    public String getItemID(){return this.ItemID;}

    public String toString() {
        return this.ItemID;
    }
}   
