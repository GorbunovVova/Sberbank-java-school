package smarthouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smarthouse.models.KettleEntity;

@Repository
public interface KettleRepo extends JpaRepository<KettleEntity, Long> {
}
