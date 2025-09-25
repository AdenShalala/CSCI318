package com.example.sales.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sales.domain.model.aggregates.Sale;
import com.example.sales.domain.model.aggregates.SaleID;

public interface SalesRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllSales();
    List<SaleID> findAllSaleIDs();
    Sale findSaleWithID(SaleID saleID);
}
