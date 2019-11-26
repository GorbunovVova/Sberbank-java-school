package smarthouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smarthouse.models.GasEntity;

@Repository
public interface GasRepo extends JpaRepository<GasEntity, Long> {
}
