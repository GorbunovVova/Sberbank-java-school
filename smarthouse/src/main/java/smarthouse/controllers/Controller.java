package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.GasEntity;
import smarthouse.models.LightEntity;
import smarthouse.models.TemperatureEntity;
import smarthouse.models.WetnessEntity;
import smarthouse.services.GasService;
import smarthouse.services.LightService;
import smarthouse.services.TemperatureService;
import smarthouse.services.WetnessService;

import java.util.Date;

@RestController
public class Controller {
    @Autowired
    private GasService gasService;
    @Autowired
    private LightService lightService;
    @Autowired
    private TemperatureService temperatureService;
    @Autowired
    private WetnessService wetnessService;

    @GetMapping("/gas/{id}")
    public GasEntity getGas(@PathVariable("id") Long id) {
        return gasService.findById(id);
    }

    @PostMapping("/gas")
    public String createGas(@RequestParam double value) {
        GasEntity gasEntity = new GasEntity(value, new Date());
        return gasService.create(gasEntity);
    }

    @GetMapping("/gas")
    public Iterable<GasEntity> getGasHistory() {
        return gasService.getAll();
    }

    @GetMapping("/light/{id}")
    public LightEntity getLight(@PathVariable("id") Long id) {
        return lightService.findById(id);
    }

    @PostMapping("/light")
    public LightEntity createLight(@RequestParam boolean toggle) {
        LightEntity lightEntity = new LightEntity(toggle, new Date());
        lightService.create(lightEntity);
        return lightEntity;
    }

    @GetMapping("/light")
    public Iterable<LightEntity> getLightHistory() {
        return lightService.getAll();
    }

    @GetMapping("/temperature/{id}")
    public TemperatureEntity getTemperature(@PathVariable("id") Long id) {
        return temperatureService.findById(id);
    }

    @PostMapping("/temperature")
    public TemperatureEntity createTemperature(@RequestParam double value) {
        TemperatureEntity temperatureEntity = new TemperatureEntity(value, new Date());
        temperatureService.create(temperatureEntity);
        return temperatureEntity;
    }

    @GetMapping("/temperature")
    public Iterable<TemperatureEntity> getTemperatureHistory() {
        return temperatureService.getAll();
    }

    @GetMapping("/wetness/{id}")
    public WetnessEntity getWetness(@PathVariable("id") Long id) {
        return wetnessService.findById(id);
    }

    @PostMapping("/wetness")
    public WetnessEntity createWetness(@RequestParam double value) {
        WetnessEntity wetnessEntity = new WetnessEntity(value, new Date());
        wetnessService.create(wetnessEntity);
        return wetnessEntity;
    }

    @GetMapping("/wetness")
    public Iterable<WetnessEntity> getWetnessHistory() {
        return wetnessService.getAll();
    }
}
