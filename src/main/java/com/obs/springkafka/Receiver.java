package com.obs.springkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Receiver {
    @Autowired
    Sender sender;

    @KafkaListener(topics = "${app.topic.request}")
    public void requestListen(@Payload String message) {
        log.info("Request received message='{}'", message);
        sender.send("Received " + message);
    }

    @KafkaListener(topics = "${app.topic.reply}")
    public void replyListen(@Payload String message) {
        log.info("Reply received message='{}'", message);
    }
}
