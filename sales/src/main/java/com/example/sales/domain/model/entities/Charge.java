package com.example.sales.domain.model.entities;

import java.util.ArrayList;
import java.util.List;

import com.example.sales.domain.model.aggregates.Sale;
import com.example.sales.domain.model.valueobjects.Price;
import com.example.sales.domain.model.valueobjects.Tag;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chargeID;

    private String type;

    @ElementCollection
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "chargeID"))
    private List<Tag> tags = new ArrayList<>();

    @Embedded
    private Price price;

    @ManyToOne
    @JoinColumn(name = "saleID")
    @JsonBackReference
    private Sale sale; // link back to sale
    private boolean isMain;
    
    public Charge(){};
    public Charge(String type, List<Tag> tags, Price price) {
        this.type = type;
        this.tags = tags;
        this.price = price;
    }
    // public Charge(Charge charge) {
    //     this.chargeID = charge.chargeID;
    //     this.type = type;
    // }

    public Long getChargeID() { return chargeID; }
    public void setChargeID(Long chargeID) { this.chargeID = chargeID; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public List<Tag> getTags() { return tags; }
    public void setTags(List<Tag> tags) { this.tags = tags; }
    public Price getPrice() { return price; }
    public void setPrice(Price price) { this.price = price; }
    public Sale getSale(){return this.sale;}
    public void setSale(Sale sale) {this.sale = sale;}
    public boolean getIsMain(){return this.isMain;}
    public void setIsMain(boolean inBool){this.isMain = inBool;}

    public String toString() {
        String output = "";
        output += "[Charge]\n";
        output += "\tType: " + this.type + "\n";
        output += "\tPrice: " + this.price.getPrice() + "\n";
        output += "\tTags: ";
        for (Tag tag: tags) {
            output += "[" + tag.getTag() + "] ";
        }
        output += "\n";

        return output;
    }
}
