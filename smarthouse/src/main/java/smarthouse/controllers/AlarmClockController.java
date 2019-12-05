package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.AlarmClockEntity;
import smarthouse.services.AlarmClockService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class AlarmClockController {
    long lastId = 0;
    @Autowired
    private AlarmClockService alarmClockService;

    @GetMapping("/alarm/{id}")
    public AlarmClockEntity getAlarm(@PathVariable("id") Long id) {
        return alarmClockService.findById(id);
    }

    @PostMapping("/alarm")
    public AlarmClockEntity createAlarm(@RequestParam String time) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date presetTime = dateFormat.parse(time);
        AlarmClockEntity alarmClockEntity = new AlarmClockEntity(true, presetTime);
        alarmClockService.create(alarmClockEntity);
        lastId = alarmClockEntity.getId();
        return alarmClockEntity;
    }

    @GetMapping("/alarm")
    public Iterable<AlarmClockEntity> getAlarmHistory() {
        return alarmClockService.getAll();
    }

    @GetMapping("/lastAlarm")
    public String getLastAlarm() {
        return lastId == 0 ? "" : String.valueOf(getAlarm(lastId).getTime());
    }
}
