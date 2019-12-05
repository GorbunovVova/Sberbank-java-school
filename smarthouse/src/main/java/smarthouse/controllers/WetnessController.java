package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.WetnessEntity;
import smarthouse.services.WetnessService;

import java.util.Date;

@RestController
public class WetnessController {
    long lastId = 0;
    @Autowired
    private WetnessService wetnessService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private final static String TOPIC = "Kafka_Example_2";

    @GetMapping("/wetness/{id}")
    public WetnessEntity getWetness(@PathVariable("id") Long id) {
        return wetnessService.findById(id);
    }

    @PostMapping("/wetness")
    public WetnessEntity createWetness(@RequestParam int value) {
        WetnessEntity wetnessEntity = new WetnessEntity(value, new Date());
        wetnessService.create(wetnessEntity);
        lastId = wetnessEntity.getId();
        return wetnessEntity;
    }

    @PostMapping("/setWetness")
    public WetnessEntity setWetness(@RequestParam int value) {
        kafkaTemplate.send(TOPIC, "wetness " + value);
        return createWetness(value);
    }

    @GetMapping("/wetness")
    public Iterable<WetnessEntity> getWetnessHistory() {
        return wetnessService.getAll();
    }

    @GetMapping("/lastWetness")
    public String getLastWetness() {
        return lastId == 0 ? "" : String.valueOf(getWetness(lastId).getValue()) + "%";
    }
}
