package com.example.sales.domain.model.commands;

import com.example.sales.domain.model.entities.Charge;

public class SalesCommand {
    //sort out Item ID's
    private String saleID;
    private Charge charge;
    


    public String getSaleID(){return this.saleID;};
    
}
