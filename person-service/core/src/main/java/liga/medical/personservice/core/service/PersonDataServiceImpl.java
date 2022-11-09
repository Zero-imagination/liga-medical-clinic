package liga.medical.personservice.core.service;

import liga.medical.personservice.core.entity.PersonData;
import liga.medical.personservice.core.repository.PersonDataRepository;
import liga.medical.personservice.core.service.api.PersonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonDataServiceImpl implements PersonDataService {

    private final PersonDataRepository personDataRepository;

    @Override
    public PersonData save(PersonData personData) {
        return personDataRepository.saveAndFlush(personData);
    }

    @Override
    public Optional<PersonData> findById(Long id) {
        return personDataRepository.findById(id);
    }

    @Override
    public List<PersonData> findAll() {
        return personDataRepository.findAll();
    }
}
