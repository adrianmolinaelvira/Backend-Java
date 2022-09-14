package com.bosonit.formacion.ej12.kafka.KafkaClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("app2")
public class KafkaTestListener2 {

    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    @KafkaListener(topics = "${message.topic.name:topic1}", groupId = "${message.group.name:group1}")
    public void listenTopic1(String message) {
        System.out.println("Recieved Message of topic1 in  listener: " + message);
        kafkaMessageProducer.sendMessage("topic2", "Mensaje Recibido: " + message);
    }

}
