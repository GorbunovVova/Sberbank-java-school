package smarthouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smarthouse.models.GameConsoleEntity;

@Repository
public interface GameConsoleRepo extends JpaRepository<GameConsoleEntity, Long> {
}
