package com.bosonit.formacion.ej12.kafka.KafkaClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("app1")
public class KafkaTestListener1 {

    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    @KafkaListener(topics = "${message.topic.name2:topic2}", groupId = "${message.group.name:group1}")
    public void listenTopic2(String message) {
        System.out.println("Recieved Message of topic2 in  listener "+message);
    }
}
