package com.kafka.producer.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {

        Map<String, String> configuration = new HashMap<>();

       configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete(borra mensaje), compact (mantiene el mensaje actual)
       configuration.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // tiempo de retención de mensajes
       configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG,"1073741824"); // tamaño máximo de segmento = 1GB
       configuration.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"1000012"); // tamaño máximo de cada mensaje = 1MB
        return TopicBuilder.name("test-topic").partitions(2).replicas(2).configs(configuration).build();
    }
}
