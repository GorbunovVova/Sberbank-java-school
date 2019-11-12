package smarthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smarthouse.models.WetnessEntity;
import smarthouse.repositories.WetnessRepo;

@Service
public class WetnessService {
    @Autowired
    private WetnessRepo wetnessRepo;

    public WetnessEntity findById(Long id) {
        return (WetnessEntity) wetnessRepo.getOne(id);
    }

    public WetnessEntity create(WetnessEntity wetnessEntity) {
        return (WetnessEntity) wetnessRepo.save(wetnessEntity);
    }

    public void deleteById(Long id) {
        wetnessRepo.deleteById(id);
    }

    public WetnessEntity update(Long id, WetnessEntity wetnessEntity) {
        wetnessEntity.setId(id);
        return (WetnessEntity) wetnessRepo.save(wetnessEntity);
    }

    public Iterable<WetnessEntity> getAll() {
        return wetnessRepo.findAll();
    }
}
