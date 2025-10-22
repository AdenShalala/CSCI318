package com.example.promotions.infrastructure.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.example.shareddomain.events.StockLowEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, StockLowEvent> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "promo-service");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, String.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StockLowEvent.class);

        // JsonDeserializer configured via constructor
        JsonDeserializer<StockLowEvent> deserializer = new JsonDeserializer<>(StockLowEvent.class);
        deserializer.setUseTypeMapperForKey(false); // required for string keys

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, StockLowEvent> kafkaListenerContainerFactory(
            ConsumerFactory<String, StockLowEvent> consumerFactory) {

        ConcurrentKafkaListenerContainerFactory<String, StockLowEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}


