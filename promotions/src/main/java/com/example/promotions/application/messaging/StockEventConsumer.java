package com.example.promotions.application.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.shareddomain.events.*;
import com.example.promotions.application.commandservices.PromoCommandService;

@Component
public class StockEventConsumer {
    
    private final PromoCommandService promoService;

    public StockEventConsumer(PromoCommandService promoService) {
        this.promoService = promoService;
    }

    @KafkaListener(
        topics = "stock.low",
        groupId = "promo-service",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void handleStockLow(StockLowEvent event) {
        System.out.println("Promotions received StockLowEvent " + event);
        // then create a promo for item
    }
}
