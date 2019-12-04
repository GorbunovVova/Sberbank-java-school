package sensorService.sensorService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.Math.random;

@Service
public class KafkaProducer {
    private boolean enabled = true;
    private int temperature = 20;
    private int wetness = 45;
    private double gas = 0.5;
    private boolean light = true;
    private boolean tv = false;
    private boolean kettle = false;
    private boolean gameConsole = false;
    private final static String TOPIC = "Kafka_Example";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private void sendMessages() throws InterruptedException {
        while (enabled) {
            setRandomTemperature();
            kafkaTemplate.send(TOPIC, "temperature " + temperature);
            Thread.sleep(1000);
            setRandomWetness();
            kafkaTemplate.send(TOPIC, "wetness " + wetness);
            Thread.sleep(1000);
            setRandomGas();
            kafkaTemplate.send(TOPIC, "gas " + gas);
            Thread.sleep(1000);
            light = setRandomBoolean();
            kafkaTemplate.send(TOPIC, "light " + light);
            Thread.sleep(1000);
            tv = setRandomBoolean();
            kafkaTemplate.send(TOPIC, "tv " + tv);
            Thread.sleep(1000);
            kettle = setRandomBoolean();
            kafkaTemplate.send(TOPIC, "kettle " + kettle);
            Thread.sleep(1000);
            gameConsole = setRandomBoolean();
            kafkaTemplate.send(TOPIC, "gameConsole " + gameConsole);
            Thread.sleep(1000);

        }
    }

    public void start() throws InterruptedException {
        enabled = true;
        sendMessages();
    }

    public void stop() {
        enabled = false;
    }

    private void setRandomTemperature() {
        double i = random();
        if (i < 0.33 && temperature > 15) {
            temperature -= 1;
        } else if (i < 0.66 && temperature < 35) {
            temperature += 1;
        }
    }

    private void setRandomWetness() {
        double i = random();
        if (i < 0.33 && wetness > 15) {
            wetness -= 1;
        } else if (i < 0.66 && wetness < 35) {
            wetness += 1;
        }
    }

    private void setRandomGas() {
        double i = random();
        if (i < 0.33 && gas > 0.1) {
            gas -= 0.1;
        } else if (i < 0.66) {
            gas += 0.1;
        }
    }

    private boolean setRandomBoolean() {
        double i = random();
        return i < 0.5;
    }
}
