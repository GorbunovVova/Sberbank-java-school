package smarthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smarthouse.models.TemperatureEntity;
import smarthouse.repositories.TemperatureRepo;

@Service
public class TemperatureService {
    @Autowired
    private TemperatureRepo temperatureRepo;

    public TemperatureEntity findById(Long id) {
        return (TemperatureEntity) temperatureRepo.getOne(id);
    }

    public TemperatureEntity create(TemperatureEntity temperatureEntity) {
        return (TemperatureEntity) temperatureRepo.save(temperatureEntity);
    }

    public void deleteById(Long id) {
        temperatureRepo.deleteById(id);
    }

    public TemperatureEntity update(Long id, TemperatureEntity temperatureEntity) {
        temperatureEntity.setId(id);
        return (TemperatureEntity) temperatureRepo.save(temperatureEntity);
    }

    public Iterable<TemperatureEntity> getAll() {
        return temperatureRepo.findAll();
    }
}
