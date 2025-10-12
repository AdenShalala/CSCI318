package com.example.warehost.interfaces.rest.dto;

public class ItemResource {
    private String itemID;
    private String type;
    private String description;
    private String orderDate;

    public ItemResource() {}

    public ItemResource(String itemID, String type, String description, String orderDate) {
        this.itemID = itemID;
        this.type = type;
        this.description = description;
        this.orderDate = orderDate;
    }

    public String getItemID(){return this.itemID;}
    public String getType(){return this.type;}
    public String getDescription(){return this.description;}
    public String getOrderDate(){return this.orderDate;}
}
