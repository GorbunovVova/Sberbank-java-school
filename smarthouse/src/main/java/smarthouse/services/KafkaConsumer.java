package smarthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import smarthouse.controllers.*;

@Service
public class KafkaConsumer {
    private final static String TOPIC = "Kafka_Example";
    private final static String GROUP_ID = "group_id";
    @Autowired
    private TemperatureController temperatureController;
    @Autowired
    private WetnessController wetnessController;
    @Autowired
    private GameConsoleController gameConsoleController;
    @Autowired
    private GasController gasController;
    @Autowired
    private KettleController kettleController;
    @Autowired
    private LightController lightController;
    @Autowired
    private TvController tvController;

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consume(String message) {
        String[] splitedMessage = message.split(" ");
        switch (splitedMessage[0]) {
            case ("temperature"):
                temperatureController.createTemperature(Integer.parseInt(splitedMessage[1]));
                break;
            case ("wetness"):
                wetnessController.createWetness(Integer.parseInt(splitedMessage[1]));
                break;
            case ("gas"):
                gasController.createGas(Double.parseDouble(splitedMessage[1]));
                break;
            case ("light"):
                lightController.createLight(Boolean.parseBoolean(splitedMessage[1]));
                break;
            case ("tv"):
                tvController.createTv(Boolean.parseBoolean(splitedMessage[1]));
                break;
            case ("kettle"):
                kettleController.createKettle(Boolean.parseBoolean(splitedMessage[1]));
                break;
            case ("gameConsole"):
                gameConsoleController.createGameConsole(Boolean.parseBoolean(splitedMessage[1]));
                break;
        }
        System.out.println("consumed message: " + message);
    }
}
