package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.TemperatureEntity;
import smarthouse.services.TemperatureService;

import java.util.Date;

@RestController
public class TemperatureController {
    long lastId = 0;
    @Autowired
    private TemperatureService temperatureService;

    @GetMapping("/temperature/{id}")
    public TemperatureEntity getTemperature(@PathVariable("id") Long id) {
        return temperatureService.findById(id);
    }

    @PostMapping("/temperature")
    public TemperatureEntity createTemperature(@RequestParam int value) {
        TemperatureEntity temperatureEntity = new TemperatureEntity(value, new Date());
        temperatureService.create(temperatureEntity);
        lastId = temperatureEntity.getId();
        return temperatureEntity;
    }

    @GetMapping("/temperature")
    public Iterable<TemperatureEntity> getTemperatureHistory() {
        return temperatureService.getAll();
    }

    @GetMapping("/lastTemperature")
    public String getLastTemperature() {
        return lastId == 0 ? "" : String.valueOf(getTemperature(lastId).getValue()) + "°С";
    }
}
