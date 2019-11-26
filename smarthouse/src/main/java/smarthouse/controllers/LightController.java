package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.LightEntity;
import smarthouse.services.LightService;

import java.util.Date;

@RestController
public class LightController {
    @Autowired
    private LightService lightService;

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

}
