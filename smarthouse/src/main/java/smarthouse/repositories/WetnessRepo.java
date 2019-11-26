package smarthouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smarthouse.models.WetnessEntity;

@Repository
public interface WetnessRepo extends JpaRepository<WetnessEntity, Long> {
}
