package smarthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smarthouse.models.GasEntity;
import smarthouse.repositories.GasRepo;

@Service
public class GasService {
    @Autowired
    private GasRepo gasRepo;

    public GasEntity findById(Long id) {
        return (GasEntity) gasRepo.getOne(id);
    }

    public String create(GasEntity gasEntity) {
        gasRepo.save(gasEntity);
        if (gasEntity.getValue() >= 1) {
            return "Опасная концентрация газа! - " + gasEntity.getValue() + "%";
        }
        return String.valueOf(gasEntity.getValue());
    }

    public void deleteById(Long id) {
        gasRepo.deleteById(id);
    }

    public GasEntity update(Long id, GasEntity gasEntity) {
        gasEntity.setId(id);
        return (GasEntity) gasRepo.save(gasEntity);
    }

    public Iterable<GasEntity> getAll() {
        return gasRepo.findAll();
    }
}
