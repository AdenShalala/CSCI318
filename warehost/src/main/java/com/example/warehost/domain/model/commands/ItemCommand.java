package com.example.warehost.domain.model.commands;

import com.example.warehost.domain.model.aggregates.ItemId;

public class ItemCommand {
    public String name;
    public String type;
    private String item_id;
    public String description;
    public String order_date;
    
    public ItemCommand() {}

    public ItemCommand(String name, String type, String description, String order_date) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.order_date = order_date;
    }
    public String getItemId() {return this.item_id;}
    public String getItemName() {return this.name;}
    public String getType() {return this.type;}
    public String getDescription() {return this.description;}
    public String getOrderDate() {return this.order_date;}

    public void setItemId(String item_id) {this.item_id = item_id;}
    public void setItemName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}
    public void setDescription(String description) {this.description = description;}
    public void setOrderDate(String order_date) {this.order_date = order_date;}
}
