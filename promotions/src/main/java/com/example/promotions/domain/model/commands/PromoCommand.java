package com.example.promotions.domain.model.commands;

import java.util.List;

import com.example.promotions.domain.model.valueobjects.Discount;
import com.example.promotions.domain.model.valueobjects.ItemID;

public class PromoCommand {
    private String startDate;
    private String endDate;
    private String promoID;
    private List<ItemID> items;
    private String promoCode;
    private Discount discount;

    public PromoCommand() {
    }

    public PromoCommand(String startDate, String endDate, List<ItemID> items, String promoCode, Discount discount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.items = items;
        this.promoCode = promoCode;
        this.discount = discount;
    }

    public String getStartDate() { return this.startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return this.endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getPromoID() { return this.promoID; }
    public void setPromoID(String promoID) { this.promoID = promoID; }

    public List<ItemID> getItems() { return this.items; }
    public void setItems(List<ItemID> items) { this.items = items; }

    public String getPromoCode() { return this.promoCode; }
    public void setPromoCode(String promoCode) { this.promoCode = promoCode; }

    public Discount getDiscount(){return this.discount;}
    public void setDiscount(Discount discount){this.discount = discount;}
}
