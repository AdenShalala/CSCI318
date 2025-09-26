package com.example.sales.domain.model.commands;

import java.sql.Date;
import java.util.List;

import com.example.sales.domain.model.entities.Charge;
import com.example.sales.interfaces.rest.dto.SalesResource;

public class SalesCommand {
    //sort out Item ID's
    private String saleID;
    private Charge charge;
    private Date date;
    private List<Charge> additionalCharges;

    public SalesCommand(){}
    public SalesCommand(SalesResource salesResource){
        this.saleID = salesResource.getSaleID();
        this.charge = salesResource.getCharge();
        this.date = salesResource.getDate();
        this.additionalCharges = salesResource.getAdditionalCharges();
    }
    

    


    public String getSaleID(){return this.saleID;};
    public Charge getCharge(){return this.charge;};
    public Date getDate(){return this.date;};
    public List<Charge> getAdditionalCharges(){return this.additionalCharges;};

    
}
