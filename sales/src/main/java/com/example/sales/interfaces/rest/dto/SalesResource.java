package com.example.sales.interfaces.rest.dto;

import java.sql.Date;
import java.util.List;

import com.example.sales.domain.model.entities.Charge;

public class SalesResource {
    private String saleID;
    private Charge charge;
    private String date;
    private List<Charge> additionalCharges;

    public SalesResource(){}

    public SalesResource(String saleID, Charge charge, String date, List<Charge> additionalCharges) {
        this.saleID = saleID;
        this.charge = charge;
        this.date = date;
        this.additionalCharges = additionalCharges;
    }

    public String getSaleID(){return this.saleID;}
    public Charge getCharge(){return this.charge;}
    public String getDate(){return this.date;}
    public List<Charge> getAdditionalCharges(){return this.additionalCharges;}
}
