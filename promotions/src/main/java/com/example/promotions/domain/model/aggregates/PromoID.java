package com.example.promotions.domain.model.aggregates;

import jakarta.persistence.Embeddable;

@Embeddable
public class PromoID {
    String promoID;

    public PromoID(){}
    public PromoID(String promoID) {
        this.promoID = promoID;
    }

    public String getPromoID(){return this.promoID;}
    public void promoID(String promoID){this.promoID = promoID;}
}
