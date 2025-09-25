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
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity
@NamedQueries ( {
    @NamedQuery (name="Sale.findAllSales", query="Select s from Sale s"),
    @NamedQuery (name="Sale.findAllSaleIDs", query="Select s.saleID from Sale s"),
    @NamedQuery (name="Sale.findSaleWithID", query="Select s from Sale s where s.SaleID = ?1")
    } )
public class Sale extends AbstractAggregateRoot<Sale> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Embedded
    private SaleID saleID;
    @Embedded
    private Charge charge;
    @ElementCollection
    @CollectionTable(name = "sale_additional_charges", joinColumns = @JoinColumn(name = "sale_id"))
    private List<Charge> additionalCharges;

    //AND CONSTRUCTORS! IMPORTANT!
    public Sale(){};

    public Sale(SalesCommand salesCommand) {
        this.saleID = new SaleID(salesCommand.getSaleID());
    }
    //Highlight your getters and setters and the like
    
}
