package com.example.sales.interfaces.rest.dto;

import java.util.List;

import com.example.sales.domain.model.entities.Charge;

public class SalesResource {
    private String itemID;
    private String saleID;
    private Charge charge;
    private String date;
    private List<Charge> additionalCharges;

    public SalesResource(){}

    public SalesResource(String saleID, String itemID, Charge charge, String date, List<Charge> additionalCharges) {
        this.saleID = saleID;
        this.itemID = itemID;
        this.charge = charge;
        this.date = date;
        this.additionalCharges = additionalCharges;
    }
    
    public String getSaleID(){return this.saleID;}
    public String getItemID(){return this.itemID;}
    public Charge getCharge(){return this.charge;}
    public String getDate(){return this.date;}
    public List<Charge> getAdditionalCharges(){return this.additionalCharges;}
}
