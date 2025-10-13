package com.example.sales.interfaces.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sales.application.commandservices.SalesCommandService;
import com.example.sales.application.queryservices.SalesQueryService;
import com.example.sales.domain.model.aggregates.Sale;
import com.example.sales.domain.model.aggregates.SaleID;
import com.example.sales.interfaces.rest.dto.SalesResource;
import com.example.sales.interfaces.rest.transform.SalesCommandDTOAssembler;

@Controller
@RequestMapping("/sales")
public class SaleController {
    //Fill with cls requests and gets
    private SalesCommandService salesCommandService;
    private SalesQueryService salesQueryService;

    public SaleController(SalesCommandService salesCommandService, SalesQueryService salesQueryService) {
        this.salesCommandService = salesCommandService;
        this.salesQueryService = salesQueryService;
    }

    @PostMapping
    @ResponseBody
    public SaleID addSale(@RequestBody SalesResource salesResource) {
        SaleID saleID = salesCommandService.addSale(SalesCommandDTOAssembler.toCommandFromDTO(salesResource));
        System.out.println("Now adding Sale " + saleID);
        return saleID;
    }

    @GetMapping("/findAllSales")
    @ResponseBody
    public List<Sale> findAllSales() {
        final List<Sale> sales = salesQueryService.findAllSales();
        System.out.println("[[ALL SALES]]");
        for (Sale sale: sales) {
            System.out.println(sale);
        }

        return sales;
    }

    @GetMapping("/findSaleWithID")
    @ResponseBody
    public Sale findSaleWithID(@RequestParam("SaleID") String saleID) {
        final Sale sale = salesQueryService.findSaleWithID(new SaleID(saleID));
        System.out.println("[SALE]");
        System.out.println(sale);
        

        return sale;
    }

    
}
