package com.example.shareddomain.events;

import java.time.Instant;

public class SaleCreatedEvent {

    private String saleID;
    private String itemID;
    private double totalAmount;
    private Instant timestamp;

    public SaleCreatedEvent(String saleID, double totalAmount, String itemID) {
        this.saleID = saleID;
        this.totalAmount = totalAmount;
        this.itemID = itemID;
        this.timestamp = Instant.now();
    }

    public SaleCreatedEvent() {}

    public String getSaleID() { return this.saleID; }
    public String getItemID() { return this.itemID; }
    public double getTotalAmount() { return this.totalAmount; }
    public Instant getTimestamp() { return this.timestamp; }

    @Override
    public String toString() {
        return "SaleCreatedEvent{" +
                "saleID='" + saleID + '\'' +
                ", itemID='" + itemID + '\'' +
                ", totalAmount=" + totalAmount +
                ", timestamp=" + timestamp +
                '}';
    }
}
