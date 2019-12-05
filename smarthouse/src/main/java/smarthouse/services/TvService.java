package smarthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smarthouse.models.TvEntity;
import smarthouse.repositories.TvRepo;

@Service
public class TvService {
    @Autowired
    private TvRepo tvRepo;

    public TvEntity findById(Long id) {
        return tvRepo.getOne(id);
    }

    public TvEntity create(TvEntity tvEntity) {
        return tvRepo.save(tvEntity);
    }

    public void deleteById(Long id) {
        tvRepo.deleteById(id);
    }

    public TvEntity update(Long id, TvEntity tvEntity) {
        tvEntity.setId(id);
        return tvRepo.save(tvEntity);
    }

    public Iterable<TvEntity> getAll() {
        return tvRepo.findAll();
    }
}
