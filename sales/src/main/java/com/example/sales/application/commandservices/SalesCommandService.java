package com.example.sales.application.commandservices;

import com.example.sales.infrastructure.repositories.*;
import com.example.shareddomain.events.SaleCreatedEvent;
import com.example.sales.domain.model.aggregates.*;
import com.example.sales.domain.model.commands.SalesCommand;
import com.example.sales.domain.model.entities.Charge;
import com.example.shareddomain.events.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class SalesCommandService {
    private final SalesRepository salesRepository;
    //outbound services here
    @Autowired
    private ApplicationEventPublisher publisher;

    public void saleRegisterCreatedEvent() {
    }

    public SalesCommandService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }
    //This saves a new sale record to the repository. Given the necessary detail it makes an id, and uses
    //a command object to instate it
    @Transactional
    public SaleID addSale(SalesCommand saleCommand) {
        //ID's will be full UUID's, no mods
        String saleID = UUID.randomUUID().toString();
        saleCommand.setSaleID(saleID);
        Sale sale = new Sale(saleCommand);
        
        if (sale.getAdditionalCharges() != null) {
            for (Charge addCharge : sale.getAdditionalCharges()) {
                addCharge.setSale(sale);
                addCharge.setIsMain(false);
            }
        }

        if (sale.getCharge() != null) {
            sale.getCharge().setSale(sale);
            sale.getCharge().setIsMain(true);
        }

        salesRepository.save(sale);
        SaleCreatedEvent event = new SaleCreatedEvent(saleID, sale.getTotalPrice(), sale.getItemID());
        publisher.publishEvent(event);
        return new SaleID(saleID);
    }


}
