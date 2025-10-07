package com.example.warehost.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemId implements Serializable {

    @Column(name="Item_id")
    private String ItemId;

    public ItemId(){}

    public ItemId(String ItemId){this.ItemId = ItemId;}

    public String getItemId(){return this.ItemId;}
}
