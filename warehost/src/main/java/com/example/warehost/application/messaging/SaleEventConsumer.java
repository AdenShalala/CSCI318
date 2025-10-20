package com.example.warehost.application.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.shareddomain.events.*;
import com.example.warehost.application.commandservices.ItemCommandService;

@Component
public class SaleEventConsumer {

    private final ItemCommandService inventoryService;

    public SaleEventConsumer(ItemCommandService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(
        topics = "sales.created",
        groupId = "inventory-service",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void handleSaleCreated(SaleCreatedEvent event) {
        System.out.println("Inventory received SaleCreatedEvent: " + event);
        //inventoryService.decrementStock(event.getItemID());
        //
        //HANDLE SALE CREATIONS HERE
    }
}
