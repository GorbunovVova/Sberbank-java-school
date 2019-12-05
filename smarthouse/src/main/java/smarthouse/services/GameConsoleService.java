package smarthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smarthouse.models.GameConsoleEntity;
import smarthouse.repositories.GameConsoleRepo;

@Service
public class GameConsoleService {
    @Autowired
    private GameConsoleRepo gameConsoleRepo;

    public GameConsoleEntity findById(Long id) {
        return gameConsoleRepo.getOne(id);
    }

    public GameConsoleEntity create(GameConsoleEntity gameConsoleEntity) {
        return gameConsoleRepo.save(gameConsoleEntity);
    }

    public void deleteById(Long id) {
        gameConsoleRepo.deleteById(id);
    }

    public GameConsoleEntity update(Long id, GameConsoleEntity gameConsoleEntity) {
        gameConsoleEntity.setId(id);
        return gameConsoleRepo.save(gameConsoleEntity);
    }

    public Iterable<GameConsoleEntity> getAll() {
        return gameConsoleRepo.findAll();
    }
}
