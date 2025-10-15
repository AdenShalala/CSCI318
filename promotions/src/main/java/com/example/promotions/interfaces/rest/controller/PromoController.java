package com.example.promotions.interfaces.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.promotions.application.commandservices.PromoCommandService;
import com.example.promotions.application.queryservices.PromoQueryService;
import com.example.promotions.domain.model.aggregates.PromoID;
import com.example.promotions.domain.model.aggregates.Promotion;
import com.example.promotions.infrastructure.repositories.PromoRepository;
import com.example.promotions.interfaces.rest.dto.PromoResource;
import com.example.promotions.interfaces.rest.transform.PromoCommandDTOAssembler;

@Controller
@RequestMapping("/promotions")
public class PromoController {
    private PromoCommandService promoCommandService;
    private PromoQueryService promoQueryService;

    public PromoController(PromoCommandService promoCommandService, PromoQueryService promoQueryService) {
        this.promoCommandService = promoCommandService;
        this.promoQueryService = promoQueryService;
    }

    @PostMapping
    @ResponseBody
    public PromoID addPromotion(@RequestBody PromoResource promoResource) {
        PromoID promoID = promoCommandService.addPromotion(PromoCommandDTOAssembler.toCommandFromDTO(promoResource));
        return promoID;
    }

    @GetMapping("/findAllPromotions")
    @ResponseBody
    public List<Promotion> findAllPromotions() {
        final List<Promotion> promotions = promoQueryService.findAllPromotions();
        return promotions;
    }

}
