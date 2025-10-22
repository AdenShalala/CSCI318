package com.example.promotions.interfaces.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.promotions.interfaces.rest.dto.Recommendation;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@CrossOrigin(origins = { "http://127.0.0.1:5500", "http://localhost:5500" })
public class RecommendationController {

  @GetMapping("/findAll")
  public List<Recommendation> getRecommendations() {
    return List.of(
        new Recommendation(1, "Increase pricing for wireless earbuds",
            "Demand elasticity analysis shows you can increase price by 8% without impacting sales volume.",
            "92%", "+$1,200/mo", "zap", "primary", "Apply"),
        new Recommendation(2, "Reorder point adjustment",
            "Sales velocity analysis suggests increasing reorder point for gaming laptops from 5 to 7 units.",
            "87%", "Reduce stockouts by 23%", "rotate-cw", "green", "Apply"),
        new Recommendation(3, "Create bundle deal",
            "Market basket analysis shows 62% of customers who buy premium headphones also buy DACs.",
            "95%", "+$3,500/mo", "tag", "purple", "Create Bundle"));
  }
}
