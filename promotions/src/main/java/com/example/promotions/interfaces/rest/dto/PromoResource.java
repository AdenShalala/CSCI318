package com.example.promotions.interfaces.rest.dto;

import java.util.List;

import com.example.promotions.domain.model.aggregates.PromoID;
import com.example.promotions.domain.model.valueobjects.Discount;
import com.example.promotions.domain.model.valueobjects.ItemID;

public class PromoResource {
    private String startDate;
    private String endDate;
    private PromoID promoID;
    private List<ItemID> items;
    private String promoCode;
    private Discount discount;

    public PromoResource(){}
    public PromoResource(String startDate, String endDate, PromoID promoID, List<ItemID> items, String promoCode, Discount discount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.promoID = promoID;
        this.items = items;
        this.promoCode = promoCode;
        this.discount = discount;
    }

    public String getStartDate() { return this.startDate; }
    public String getEndDate() { return this.endDate; }
    public PromoID getPromoID() { return this.promoID; }
    public List<ItemID> getItems() { return this.items; }
    public String getPromoCode() { return this.promoCode; }
    public Discount getDiscount() { return this.discount; }
}
