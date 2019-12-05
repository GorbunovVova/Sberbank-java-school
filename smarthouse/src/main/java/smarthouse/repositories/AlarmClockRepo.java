package smarthouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smarthouse.models.AlarmClockEntity;

@Repository
public interface AlarmClockRepo extends JpaRepository<AlarmClockEntity, Long> {
}