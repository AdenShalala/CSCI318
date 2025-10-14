package com.example.warehost.domain.model.commands;

import java.util.Date;

import com.example.warehost.domain.model.aggregates.ItemId;

public class ItemCommand {
    public String type;
    private String item_id;
    public String description;
    public String order_date;
    
    public ItemCommand() {}

    public ItemCommand(String item_id, String type, String description, String order_date) {
        this.item_id = item_id;
        this.type = type;
        this.description = description;
        this.order_date = order_date;
    }
    public String getItemId() {
        return item_id;
    }
    public void setItemId(String item_id) {
        this.item_id = item_id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getOrderDate() {
        return order_date;
    }
    public void setOrderDate(String order_date) {
        this.order_date = order_date;
    }
}
