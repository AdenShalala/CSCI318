package com.example.shareddomain;

import java.util.List;

public class Promotion {
    private String startDate;
    private String endDate;
    private String promoID;
    private List<String> items;
    private String promoCode;
    private Discount discount; 

    public Promotion(){}
    public Promotion(String startDate, String endDate, String promoID, List<String> items, String promoCode, Discount discount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.promoID = promoID;
        this.items = items;
        this.promoCode = promoCode;
        this.discount = discount;
    }

    public String getStartDate(){return this.startDate;}
    public String getEndDate(){return this.endDate;}
    public String getPromoID(){return this.promoID;}
    public List<String> getItems(){return this.items;}
    public String getPromoCode() {return this.promoCode;}
    public Discount getDiscount() {return this.discount;}

    public void setStartDate(String startDate){this.startDate = startDate;}
    public void setEndDate(String endDate){this.endDate = endDate;}
    public void setPromoId(String promoID){this.promoID = promoID;}
    public void setItems(List<String> items){this.items = items;}
    public void setPromoCode(String promoCode){this.promoCode = promoCode;}
    public void setDiscount(Discount discount){this.discount = discount;}
}
