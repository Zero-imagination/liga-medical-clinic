package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.entity.PersonData;

import java.util.List;
import java.util.Optional;

public interface PersonDataService {

    PersonData save(PersonData personData);

    Optional<PersonData> findById(Long id);

    List<PersonData> findAll();

}
