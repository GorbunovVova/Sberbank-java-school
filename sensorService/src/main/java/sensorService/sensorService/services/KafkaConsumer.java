package sensorService.sensorService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private final static String TOPIC = "Kafka_Example_2";
    private final static String GROUP_ID = "group_id";
    @Autowired
    private KafkaProducer kafkaProducer;

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consume(String message) {
        String[] splitedMessage = message.split(" ");
        switch (splitedMessage[0]) {
            case ("temperature"):
                kafkaProducer.setTemperature(Integer.parseInt(splitedMessage[1]));
                break;
            case ("wetness"):
                kafkaProducer.setWetness(Integer.parseInt(splitedMessage[1]));
                break;
        }
        System.out.println("consumed message: " + message);
    }
}
