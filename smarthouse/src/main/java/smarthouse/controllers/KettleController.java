package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.KettleEntity;
import smarthouse.services.KettleService;

import java.util.Date;

@RestController
public class KettleController {
    long lastId = 0;
    @Autowired
    private KettleService kettleService;

    @GetMapping("/kettle/{id}")
    public KettleEntity getKettle(@PathVariable("id") Long id) {
        return kettleService.findById(id);
    }

    @PostMapping("/kettle")
    public KettleEntity createKettle(@RequestParam boolean toggle) {
        KettleEntity kettleEntity = new KettleEntity(toggle, new Date());
        kettleService.create(kettleEntity);
        lastId = kettleEntity.getId();
        return kettleEntity;
    }

    @GetMapping("/kettle")
    public Iterable<KettleEntity> getKettleHistory() {
        return kettleService.getAll();
    }

    @GetMapping("/lastKettle")
    public String getLastKettle() {
        return lastId == 0 ? "" : getKettle(lastId).isToggle() ? "Чайник включен" : "Чайник выключен";
    }
}
