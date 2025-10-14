package com.example.shareddomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sale implements Serializable{
    private String saleID;

    private String date;
    private String itemID;

    private Charge charge;

    private List<Charge> additionalCharges = new ArrayList<>();

    public Sale() {}

    public Sale(String saleID, String date, String itemID, Charge charge, List<Charge> additionalCharges) {
        this.saleID = saleID;
        this.date = date;
        this.itemID = itemID;
        this.charge = charge;
        this.additionalCharges = additionalCharges;
    }

    public String getSaleID() { return saleID; }
    public void setSaleID(String saleID) { this.saleID = saleID; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getItemID() { return itemID; }
    public void setItemID(String itemID) { this.itemID = itemID; }

    public Charge getCharge() { return charge; }
    public void setCharge(Charge charge) { this.charge = charge; }

    public List<Charge> getAdditionalCharges() { return additionalCharges; }
    public void setAdditionalCharges(List<Charge> additionalCharges) { this.additionalCharges = additionalCharges; }
    
}
