package liga.medical.personservice.core.impl;

import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.repository.PersonDataRepository;
import liga.medical.personservice.core.service.PersonDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonDataServiceImpl implements PersonDataService {

    private final PersonDataRepository personDataRepository;

    public PersonDataServiceImpl(PersonDataRepository personDataRepository) {
        this.personDataRepository = personDataRepository;
    }

    @Override
    public PersonData addPersonData(PersonData personData) {
        return personDataRepository.saveAndFlush(personData);
    }

    @Override
    public void deletePersonData(PersonData personData) {
        personDataRepository.delete(personData);
    }

    @Override
    public Optional<PersonData> getPersonDataById(Long id) {
        return personDataRepository.findById(id);
    }

    @Override
    public PersonData editPersonData(PersonData personData) {
        return personDataRepository.saveAndFlush(personData);
    }

    @Override
    public List<PersonData> getAll() {
        return personDataRepository.findAll();
    }
}
