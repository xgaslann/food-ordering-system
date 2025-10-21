package com.xgaslan.kafka.producer.service.impl;

import com.xgaslan.kafka.producer.KafkaMessageHelper;
import com.xgaslan.kafka.producer.exception.KafkaProducerException;
import com.xgaslan.kafka.producer.service.KafkaProducer;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class KafkaProducerImpl<K extends Serializable, V extends SpecificRecordBase> implements KafkaProducer<K, V> {

    private final KafkaTemplate<K, V> kafkaTemplate;
    private final KafkaMessageHelper kafkaMessageHelper;

    public KafkaProducerImpl(KafkaTemplate<K, V> kafkaTemplate,
                             KafkaMessageHelper kafkaMessageHelper) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void send(String topicName, K key, V message) {
        log.info("Sending message={} to topic={}", message, topicName);
        try {
            CompletableFuture<SendResult<K, V>> future = kafkaTemplate.send(topicName, key, message);
            kafkaMessageHelper.addCallback(
                    future,
                    topicName,
                    message,
                    key.toString(),
                    message.getClass().getSimpleName()
            );
        } catch (KafkaException e) {
            log.error("KafkaException occurred while sending message to topic: {} with key: {} - {}",
                    topicName, key, e.getMessage());
            throw new KafkaProducerException("Error on kafka producer with key: " + key + " and message: " + message);
        }
    }


    @PreDestroy
    public void close() {
        if (kafkaTemplate != null) {
            log.info("Closing kafka producer!");
            kafkaTemplate.destroy();
        }
    }
}