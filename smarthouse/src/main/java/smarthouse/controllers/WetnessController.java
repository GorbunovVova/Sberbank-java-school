package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.WetnessEntity;
import smarthouse.services.WetnessService;

import java.util.Date;

@RestController
public class WetnessController {
    @Autowired
    private WetnessService wetnessService;

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
