package home.narvekar.spring.boot.application.registration.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrationKafkaProducer {

    private static final String TOPIC_NAME = "registration_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produce(String message) {
        System.out.println("message is going to be produced as : " + message);
        kafkaTemplate.send(TOPIC_NAME, message);
    }

}
