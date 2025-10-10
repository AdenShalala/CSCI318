package com.example.sales.application.queryservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sales.domain.model.aggregates.Sale;
import com.example.sales.domain.model.aggregates.SaleID;
import com.example.sales.infrastructure.repositories.SalesRepository;

@Service
public class SalesQueryService {
    private final SalesRepository salesRepository;

    public SalesQueryService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sale> findAllSales(){
        return salesRepository.findAllSales();
    }

    public List<SaleID> findAllSaleIDs() {
        return salesRepository.findAllSaleIDs();
    }

    public Sale findSaleID(SaleID saleID) {
        return salesRepository.findSaleWithID(saleID);
    }

    public List<Sale> findSalesByItemID(String itemID) {
        return salesRepository.findSalesByItemID(itemID);
    }
}
