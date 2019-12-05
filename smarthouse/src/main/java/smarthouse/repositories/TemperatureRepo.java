package smarthouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smarthouse.models.TemperatureEntity;

@Repository
public interface TemperatureRepo extends JpaRepository<TemperatureEntity, Long> {
}