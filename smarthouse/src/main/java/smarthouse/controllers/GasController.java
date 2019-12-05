package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.GasEntity;
import smarthouse.services.GasService;

import java.util.Date;

@RestController
public class GasController {
    long lastId = 0;
    @Autowired
    private GasService gasService;

    @GetMapping("/gas/{id}")
    public GasEntity getGas(@PathVariable("id") Long id) {
        return gasService.findById(id);
    }

    @PostMapping("/gas")
    public GasEntity createGas(@RequestParam double value) {
        GasEntity gasEntity = new GasEntity(value, new Date());
        gasService.create(gasEntity);
        lastId = gasEntity.getId();
        return gasEntity;
    }

    @GetMapping("/gas")
    public Iterable<GasEntity> getGasHistory() {
        return gasService.getAll();
    }

    @GetMapping("/lastGas")
    public String getLastGas() {
        if (lastId == 0) return "";
        double value = getGas(lastId).getValue();
        value = (Double) Math.floor(value * 100) / 100.0;
        return String.valueOf(value) + "%";
    }
}
