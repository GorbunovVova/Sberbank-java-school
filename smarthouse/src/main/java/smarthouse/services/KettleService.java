package smarthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smarthouse.models.KettleEntity;
import smarthouse.repositories.KettleRepo;

@Service
public class KettleService {
    @Autowired
    private KettleRepo kettleRepo;

    public KettleEntity findById(Long id) {
        return kettleRepo.getOne(id);
    }

    public KettleEntity create(KettleEntity kettleEntity) {
        return kettleRepo.save(kettleEntity);
    }

    public void deleteById(Long id) {
        kettleRepo.deleteById(id);
    }

    public KettleEntity update(Long id, KettleEntity kettleEntity) {
        kettleEntity.setId(id);
        return kettleRepo.save(kettleEntity);
    }

    public Iterable<KettleEntity> getAll() {
        return kettleRepo.findAll();
    }
}
