package sensorService.sensorService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sensorService.sensorService.services.KafkaProducer;

@RestController
@RequestMapping("sensorService")
public class StartController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/start")
    public void startGenerateSensorsReadings() throws InterruptedException {
        kafkaProducer.start();
    }
    @GetMapping("/stop")
    public void stopGenerateSensorsReadings() {
        kafkaProducer.stop();
    }
}
