package com.example.promotions.application.commandservices;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.promotions.domain.model.aggregates.PromoID;
import com.example.promotions.domain.model.aggregates.Promotion;
import com.example.promotions.domain.model.commands.PromoCommand;
import com.example.promotions.infrastructure.repositories.PromoRepository;

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
}
