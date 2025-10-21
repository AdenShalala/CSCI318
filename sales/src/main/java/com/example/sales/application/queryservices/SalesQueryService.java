package com.example.sales.application.queryservices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sales.domain.model.aggregates.Sale;
import com.example.sales.domain.model.aggregates.SaleID;
import com.example.sales.domain.model.entities.Charge;
import com.example.sales.infrastructure.repositories.SalesRepository;

@Service
public class SalesQueryService {
    private final SalesRepository salesRepository;

    public SalesQueryService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sale> findAllSales(){
        List<Sale> sales = salesRepository.findAllSales();
        for (Sale sale : sales) {
            sale = parseSale(sale);
        }
        
        return sales;
    }

    public List<SaleID> findAllSaleIDs() {
        return salesRepository.findAllSaleIDs();
    }

    public Sale findSaleWithID(SaleID saleID) {
        Sale sale = salesRepository.findSaleWithID(saleID);

        return parseSale(sale);
        // return salesRepository.findSaleWithID(saleID);
    }

    public List<Sale> findSalesByItemID(String itemID) {
        return salesRepository.findSalesByItemID(itemID);
    }

    public Sale parseSale(Sale sale) {
        Charge main = sale.getAdditionalCharges()
            .stream()
            .filter(Charge::getIsMain)
            .findFirst()
            .orElse(null);

        List<Charge> extras = sale.getAdditionalCharges()
            .stream()
            .filter(c -> !c.getIsMain())
            .collect(Collectors.toList());

        sale.setCharge(main);
        sale.setAdditionalCharges(extras);
        return sale;
    }

    public List<Sale> findSalesAboveAmount(double amount) {
        List<Sale> sales = salesRepository.findAllSales();
        return sales.stream()
                .filter(sale -> sale.getTotalPrice() > amount)
                .collect(Collectors.toList());
    }
}
