package com.example.sales.domain.model.commands;

import java.sql.Date;
import java.util.List;

import com.example.sales.domain.model.entities.Charge;
import com.example.sales.interfaces.rest.dto.SalesResource;

public class SalesCommand {
    //sort out Item ID's
    private String saleID;
    private String itemID;
    private Charge charge;
    private String date;
    private List<Charge> additionalCharges;

    public SalesCommand(){}
    // public SalesCommand(SalesResource salesResource){
    //     this.saleID = salesResource.getSaleID();
    //     this.charge = salesResource.getCharge();
    //     this.date = salesResource.getDate();
    //     this.additionalCharges = salesResource.getAdditionalCharges();
    // }
    public SalesCommand(Charge charge, String date, List<Charge> additionalCharges) {

        this.charge = charge;
        this.date = date;
        this.additionalCharges = additionalCharges;
    }
    public void setSaleID(String saleID){this.saleID = saleID;}
    

    


    public String getSaleID(){return this.saleID;}
    public String getItemID(){return this.itemID;}
    public Charge getCharge(){return this.charge;}
    public String getDate(){return this.date;}
    public List<Charge> getAdditionalCharges(){return this.additionalCharges;}

    
}
