package smarthouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smarthouse.models.LightEntity;

@Repository
public interface LightRepo extends JpaRepository<LightEntity, Long> {
}
