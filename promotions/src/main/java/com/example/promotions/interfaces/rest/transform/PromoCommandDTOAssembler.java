package com.example.promotions.interfaces.rest.transform;

import com.example.promotions.domain.model.commands.PromoCommand;
import com.example.promotions.interfaces.rest.dto.PromoResource;

public class PromoCommandDTOAssembler {
    public static PromoCommand toCommandFromDTO(PromoResource promoResource) {
        return new PromoCommand(
            promoResource.getStartDate(),
            promoResource.getEndDate(),
            promoResource.getItems(),
            promoResource.getPromoCode(),
            promoResource.getDiscount()
        );
    }
    
}
