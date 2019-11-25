package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.GasEntity;
import smarthouse.services.GasService;

import java.util.Date;

@RestController
public class GasController {
    @Autowired
    private GasService gasService;

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
}
