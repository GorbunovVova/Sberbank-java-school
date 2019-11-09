package task5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task5.models.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
