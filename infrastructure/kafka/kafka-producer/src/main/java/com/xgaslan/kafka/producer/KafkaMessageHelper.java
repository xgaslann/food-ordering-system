package com.xgaslan.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class KafkaMessageHelper {

    public <K, V> void addCallback(
            CompletableFuture<SendResult<K, V>> future,
            String responseTopicName,
            V avroModel,
            String orderId,
            String avroModelName) {

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Error while sending {} message {} to topic {}",
                        avroModelName, avroModel.toString(), responseTopicName, ex);
            } else {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Received successful response from Kafka for order id: {} " +
                                "Topic: {} Partition: {} Offset: {} Timestamp: {}",
                        orderId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp());
            }
        });
    }
}