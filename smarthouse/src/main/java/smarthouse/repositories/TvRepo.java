package smarthouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smarthouse.models.TvEntity;

@Repository
public interface TvRepo extends JpaRepository<TvEntity, Long> {
}
