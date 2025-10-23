package com.example.promotions.application.commandservices;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.promotions.domain.model.aggregates.PromoID;
import com.example.promotions.domain.model.aggregates.Promotion;
import com.example.promotions.domain.model.commands.PromoCommand;
import com.example.promotions.infrastructure.repositories.PromoRepository;
import com.example.promotions.domain.model.valueobjects.Discount;
import com.example.promotions.domain.model.valueobjects.ItemID;

@Service
public class PromoCommandService {
    private final PromoRepository promoRepository;

    public PromoCommandService(PromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }

    public PromoID addPromotion(PromoCommand promoCommand) {
        //ID's will be full UUID's, no mods
        String promoID = UUID.randomUUID().toString();
        promoCommand.setPromoID(promoID);
        Promotion promotion = new Promotion(promoCommand);
        promoRepository.save(promotion);

        return new PromoID(promoID);
    }

    public void deletePromotion(PromoID promoID) {
        Promotion promotion = promoRepository.findPromotionByPromoID(promoID);
        promoRepository.delete(promotion);
    }
    public void updatePromotion(PromoCommand promoCommand) {
        Promotion promotion = promoRepository.findPromotionByPromoID(new PromoID(promoCommand.getPromoID()));
        promotion.updateDetails(promoCommand);
        promoRepository.save(promotion);
    }

    public void createPromotionForLowStock(String itemID, String itemName, int newQuantity, String startDate) {
        String promoCode = itemID.substring(0, itemID.indexOf("-"));

        int endDateInt = Integer.parseInt(startDate) + 7000000; // 7 days later 22102025 + 7000000
        String endDate = String.valueOf(endDateInt);

        PromoCommand promoCommand = new PromoCommand(
            startDate, // startDate
            endDate, // endDate
            Arrays.asList(new ItemID(itemID)), // items
            "LOWSTOCK-" + promoCode, // promoCode
            new Discount("standard", 15.0)  // discount
        );

        this.addPromotion(promoCommand);
    }
}
