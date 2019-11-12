package smarthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smarthouse.models.LightEntity;
import smarthouse.repositories.LightRepo;

@Service
public class LightService {
    @Autowired
    private LightRepo lightRepo;

    public LightEntity findById(Long id) {
        return (LightEntity) lightRepo.getOne(id);
    }

    public LightEntity create(LightEntity lightEntity) {
        return (LightEntity) lightRepo.save(lightEntity);
    }

    public void deleteById(Long id) {
        lightRepo.deleteById(id);
    }

    public LightEntity update(Long id, LightEntity lightEntity) {
        lightEntity.setId(id);
        return (LightEntity) lightRepo.save(lightEntity);
    }

    public Iterable<LightEntity> getAll() {
        return lightRepo.findAll();
    }
}