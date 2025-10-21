package com.example.shareddomain;

import java.io.Serializable;

public class Item implements Serializable{
    private String itemID;
    private String type;
    private String description;
    private String order_date;

    public Item(String itemID, String type, String description, String order_date) {
        this.itemID = itemID;
        this.type = type;
        this.description = description;
        this.order_date = order_date;
    }

    public String getItemId() { return itemID; }
    public void setItemId(String itemId) { this.itemID = itemId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getOrder_date() { return order_date; }
    public void setOrder_date(String order_date) { this.order_date = order_date; }
}
