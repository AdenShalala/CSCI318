package com.example.warehost.interfaces.rest.dto;

public class ItemResource {
    private String itemID;
    private String name;
    private String type;
    private String description;
    private String quantity;

    public ItemResource() {}

    public ItemResource(String itemID, String name, String type, String description, String quantity) {
        this.itemID = itemID;
        this.name =name;
        this.type = type;
        this.description = description;
        this.quantity = quantity;
    }

    public String getItemID(){return this.itemID;}
    public String getName(){return this.name;}
    public String getType(){return this.type;}
    public String getDescription(){return this.description;}
    public String getQuantity(){return this.quantity;}

}
