package com.example.sales.interfaces.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sales.application.commandservices.SalesCommandService;
import com.example.sales.application.queryservices.SalesQueryService;

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
    
}
