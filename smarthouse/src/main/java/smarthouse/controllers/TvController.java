package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.TvEntity;
import smarthouse.services.TvService;

import java.util.Date;

@RestController
public class TvController {
    long lastId = 0;
    @Autowired
    private TvService tvService;

    @GetMapping("/tv/{id}")
    public TvEntity getTv(@PathVariable("id") Long id) {
        return tvService.findById(id);
    }

    @PostMapping("/tv")
    public TvEntity createTv(@RequestParam boolean toggle) {
        TvEntity tvEntity = new TvEntity(toggle, new Date());
        tvService.create(tvEntity);
        lastId = tvEntity.getId();
        return tvEntity;
    }

    @GetMapping("/tv")
    public Iterable<TvEntity> getTvHistory() {
        return tvService.getAll();
    }

    @GetMapping("/lastTv")
    public String getLastTv() {
        return lastId == 0 ? "" : getTv(lastId).isToggle() ? "Телевизор включен" : "Телевизор выключен";
    }
}
