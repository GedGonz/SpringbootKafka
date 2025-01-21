package com.kafka.consumer.config.listeners;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = "test-topic", groupId = "group-id")
    public void listen(String message){
        logger.info("Mensaje recibido: "+message);
    }
}
