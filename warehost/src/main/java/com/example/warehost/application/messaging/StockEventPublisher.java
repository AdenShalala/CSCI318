package com.example.warehost.application.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.example.shareddomain.events.*;

@Component
public class StockEventPublisher {
    
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public StockEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @TransactionalEventListener
    public void handleStockLowEvent(StockLowEvent event){
        kafkaTemplate.send("stock.low", event.getItemID(), event);
        System.out.println("Published StockLowEvent to kafka: " + event);
    }
}
