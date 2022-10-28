package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.PersonData;

import java.util.List;
import java.util.Optional;

public interface PersonDataService {

    PersonData addPersonData(PersonData personData);

    void deletePersonData(PersonData personData);

    Optional<PersonData> getPersonDataById(Long id);

    PersonData editPersonData(PersonData personData);

    List<PersonData> getAll();

}
