package com.example.shareddomain;

import java.io.Serializable;

public class Item implements Serializable{
    private String itemId;
    private String type;
    private String description;
    private String order_date;

    public Item(String itemId, String type, String description, String order_date) {
        this.itemId = itemId;
        this.type = type;
        this.description = description;
        this.order_date = order_date;
    }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getOrder_date() { return order_date; }
    public void setOrder_date(String order_date) { this.order_date = order_date; }
}
