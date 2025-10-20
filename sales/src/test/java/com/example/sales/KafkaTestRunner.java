package com.example.sales;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.shareddomain.events.SaleCreatedEvent;

import org.springframework.kafka.core.KafkaTemplate;

@Component
public class KafkaTestRunner implements CommandLineRunner {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaTestRunner(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Publishing test SaleCreatedEvent...");

        SaleCreatedEvent testEvent = new SaleCreatedEvent("TEST123", "ITEM001");
        kafkaTemplate.send("sales.created", testEvent.getSaleID(), testEvent);

        System.out.println("✅ Test event sent!");
    }
}