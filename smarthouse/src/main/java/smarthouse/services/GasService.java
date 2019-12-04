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
        return gasRepo.getOne(id);
    }

    public GasEntity create(GasEntity gasEntity) {
        return gasRepo.save(gasEntity);
    }

    public void deleteById(Long id) {
        gasRepo.deleteById(id);
    }

    public GasEntity update(Long id, GasEntity gasEntity) {
        gasEntity.setId(id);
        return gasRepo.save(gasEntity);
    }

    public Iterable<GasEntity> getAll() {
        return gasRepo.findAll();
    }
}
