package com.example.warehost.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemID implements Serializable {

    @Column(name="Item_id")
    private String ItemId;

    public ItemID(){}

    public ItemID(String ItemId){this.ItemId = ItemId;}

    public String getItemID(){return this.ItemId;}
}
