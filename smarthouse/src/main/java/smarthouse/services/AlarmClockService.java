package smarthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smarthouse.models.AlarmClockEntity;
import smarthouse.repositories.AlarmClockRepo;

@Service
public class AlarmClockService {
    @Autowired
    private AlarmClockRepo alarmClockRepo;

    public AlarmClockEntity findById(Long id) {
        return alarmClockRepo.getOne(id);
    }

    public AlarmClockEntity create(AlarmClockEntity alarmClockEntity) {
        return alarmClockRepo.save(alarmClockEntity);
    }

    public void deleteById(Long id) {
        alarmClockRepo.deleteById(id);
    }

    public AlarmClockEntity update(Long id, AlarmClockEntity alarmClockEntity) {
        alarmClockEntity.setId(id);
        return alarmClockRepo.save(alarmClockEntity);
    }

    public Iterable<AlarmClockEntity> getAll() {
        return alarmClockRepo.findAll();
    }
}

