package com.example.sales.application.commandservices;

import com.example.sales.infrastructure.repositories.*;
import com.example.sales.domain.model.aggregates.*;
import com.example.sales.domain.model.commands.SalesCommand;
import com.example.sales.domain.model.entities.Charge;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class SalesCommandService {
    private final SalesRepository salesRepository;
    //outbound services here

    public SalesCommandService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }
    //This saves a new sale record to the repository. Given the necessary detail it makes an id, and uses
    //a command object to instate it
    public SaleID addSale(SalesCommand saleCommand) {
        //ID's will be full UUID's, no mods
        String saleID = UUID.randomUUID().toString();
        //Unnescessary, just a check for now, remove?
        saleCommand.setSaleID(saleID);
        Sale sale = new Sale(saleCommand);
        
        if (sale.getAdditionalCharges() != null) {
            for (Charge addCharge : sale.getAdditionalCharges()) {
                addCharge.setSale(sale);
            }
        }

        if (sale.getCharge() != null) {
            sale.getCharge().setSale(sale);
        }

        salesRepository.save(sale);
        return new SaleID(saleID);
    }


}
