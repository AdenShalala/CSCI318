package com.example.promotions.interfaces.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.promotions.interfaces.rest.dto.Insight;

import java.util.List;

@RestController
@RequestMapping("/insights")
@CrossOrigin(origins = { "http://127.0.0.1:5500", "http://localhost:5500" })
public class InsightController {

  @GetMapping("/findAll")
  public List<Insight> getInsights() {
    return List.of(
        new Insight(1, "Inventory Turnover", "2.8x", "+12%", "Last 30 days", "trending-up", "green"),
        new Insight(2, "Top Selling", "Smartwatch Pro", "128 units sold", null, "award", "yellow"),
        new Insight(3, "Reorder Alert", "3 Items", "Below safety stock", null, "alert-triangle", "red"),
        new Insight(4, "Revenue Forecast", "$42.5K", "+8%", "Next 30 days", "dollar-sign", "blue"));
  }
}
