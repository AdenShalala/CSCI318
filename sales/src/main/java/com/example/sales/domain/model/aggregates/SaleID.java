package com.example.sales.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SaleID implements Serializable {
    
    @Column(name="saleID")
    private String saleID;
    
    public SaleID(){};

    public SaleID(String saleID) {this.saleID = saleID;};

    public String getSaleID() {return this.saleID;};

}
