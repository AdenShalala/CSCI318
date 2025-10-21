package com.example.shareddomain.events;

import java.time.Instant;

public class StockLowEvent {
    
    private String itemID;
    private String itemName;
    private int quantity;
    private Instant timestamp;

    public StockLowEvent(String itemID) {
        this.itemID = itemID;
        this.timestamp = Instant.now();
    }

    public String getItemID() {return itemID;}
    public String getItemName() {return itemName;}
    public int getQuantity() {return quantity;}
    public Instant getTimestamp() {return timestamp;}

    @Override
    public String toString() {
        return "StockLowEvent{" +
                "itemID='" + itemID + "\'" +
                "itemName='" + itemName + "\'" +
                "quantity='" + quantity + "\'" +
                "timestamp='" + timestamp + "\'" + 
                "}";
    }
}
