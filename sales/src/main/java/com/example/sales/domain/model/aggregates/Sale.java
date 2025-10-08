package com.example.sales.domain.model.aggregates;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.example.sales.domain.model.commands.SalesCommand;
import com.example.sales.domain.model.entities.Charge;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NamedQueries ( {
    @NamedQuery (name="Sale.findAllSales", query="Select s from Sale s"),
    @NamedQuery (name="Sale.findAllSaleIDs", query="Select s.saleID from Sale s"),
    @NamedQuery (name="Sale.findSaleWithID", query="Select s from Sale s where s.saleID = ?1")
    } )
public class Sale extends AbstractAggregateRoot<Sale> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private SaleID saleID;

    private String date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="chargeID")
    private Charge charge;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Charge> additionalCharges = new ArrayList<>();

    //AND CONSTRUCTORS! IMPORTANT!
    public Sale(){};

    public Sale(SalesCommand salesCommand) {
    this.saleID = new SaleID(salesCommand.getSaleID());
    this.date = salesCommand.getDate(); // if applicable

    if (salesCommand.getCharge() != null) {
        this.charge = salesCommand.getCharge();
        this.charge.setSale(this);
    }

    if (salesCommand.getAdditionalCharges() != null) {
        this.additionalCharges = salesCommand.getAdditionalCharges()
                                           .stream()
                                           .map(c -> {
                                               c.setSale(this);
                                               return c;
                                           })
                                           .collect(Collectors.toList());
    }
}
    //Highlight your getters and setters and the like
    public SaleID getSaleID(){return this.saleID;}
    public Charge getCharge(){return this.charge;}
    public String getDate(){return this.date;}
    public List<Charge> getAdditionalCharges(){return this.additionalCharges;}

    public void setSaleID(SaleID saleID) { this.saleID = saleID; }
    public void setCharge(Charge charge) { this.charge = charge; }
    public void setDate(String date) { this.date = date; }
    public void setAdditionalCharges(List<Charge> additionalCharges) { this.additionalCharges = additionalCharges; }
    
}
