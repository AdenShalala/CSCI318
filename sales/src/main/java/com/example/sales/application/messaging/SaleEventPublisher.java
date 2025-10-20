package com.example.sales.application.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.example.shareddomain.events.*;

@Component
public class SaleEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public SaleEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @TransactionalEventListener
    public void handleSaleCreatedEvent(SaleCreatedEvent event) {
        kafkaTemplate.send("sales.created", event.getSaleID(), event);
        System.out.println("Published SaleCreatedEvent to Kafka: " + event);
    }
}
