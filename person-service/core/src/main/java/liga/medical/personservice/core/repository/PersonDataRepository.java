package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDataRepository extends JpaRepository<PersonData, Long> {
}
