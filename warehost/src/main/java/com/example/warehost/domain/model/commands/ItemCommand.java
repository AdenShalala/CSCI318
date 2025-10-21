package com.example.warehost.domain.model.commands;

public class ItemCommand {
    public String name;
    public String type;
    private String itemID;
    public String description;
    public String order_date;
    public String quantity;
    
    public ItemCommand() {}

    public ItemCommand(String name, String type, String description, String order_date, String quantity) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.order_date = order_date;
        this.quantity = quantity;
    }
    public String getItemID() {return this.itemID;}
    public String getItemName() {return this.name;}
    public String getType() {return this.type;}
    public String getDescription() {return this.description;}
    public String getOrderDate() {return this.order_date;}
    public String getQuantity() {return this.quantity;}

    public void setItemID(String itemID) {this.itemID = itemID;}
    public void setItemName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}
    public void setDescription(String description) {this.description = description;}
    public void setOrderDate(String order_date) {this.order_date = order_date;}
    public void setQuantity(String quantity) {this.quantity = quantity;}
}
