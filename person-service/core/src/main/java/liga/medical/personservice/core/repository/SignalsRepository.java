package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.entity.Signal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignalsRepository extends JpaRepository<Signal, Long> {
    List<Signal> findAllByPersonDataId(Long personDataId);
}
