package com.example.promotions.application.queryservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.promotions.domain.model.aggregates.PromoID;
import com.example.promotions.domain.model.aggregates.Promotion;
import com.example.promotions.infrastructure.repositories.PromoRepository;

@Service
public class PromoQueryService {
    private final PromoRepository promoRepository;

    public PromoQueryService(PromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }
    public List<Promotion> findAllPromotions() {
        List<Promotion> promotions = promoRepository.findAllPromotions();
        return promotions;
    }
    public List<Promotion> findPromotionByID(String promoID) {
        List<Promotion> promotions = promoRepository.findPromotionByPromoID(new PromoID(promoID));
        return promotions;
    }
}
