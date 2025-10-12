package com.example.warehost.model.commands;

import java.util.Date;
import com.example.warehost.model.aggregates.ItemID;

public class AddItemCommand {
    public String type;
    private String item_id;
    public String description;
    public Date order_date;
    
    public AddItemCommand() {}

    public AddItemCommand(String item_id, String type, String description, Date order_date) {
        this.item_id = item_id;
        this.type = type;
        this.description = description;
        this.order_date = order_date;
    }
    public String getItemID() {
        return item_id;
    }
    public void setItemID(String item_id) {
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
    public Date getOrderDate() {
        return order_date;
    }
    public void setOrderDate(Date order_date) {
        this.order_date = order_date;
    }
}
