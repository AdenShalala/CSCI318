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
        String time = event.getTimestamp().toString();
        String datePart = time.substring(0, 10); // "2025-10-22"
        
        // Split into components
        String[] parts = datePart.split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];
        
        // Reformat into DDMMYYYY
        String formatted = day + month + year;

        promoService.createPromotionForLowStock(event.getItemID(), event.getItemName(), event.getQuantity(), formatted);
    }
}
