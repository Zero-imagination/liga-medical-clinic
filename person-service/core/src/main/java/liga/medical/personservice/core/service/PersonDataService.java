package liga.medical.personservice.core.service;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.api.service.IService;
import liga.medical.personservice.core.model.PersonData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDataService implements IService<PersonData> {

    private final IRepository<PersonData> personDataRepository;

    public PersonDataService(IRepository<PersonData> personDataRepository) {
        this.personDataRepository = personDataRepository;
    }

    @Override
    public List<PersonData> getAll() {
        return personDataRepository.getAll();
    }

    @Override
    public PersonData getById(long id) {
        return personDataRepository.getById(id);
    }

    @Override
    public int insert(PersonData personData) {
        return personDataRepository.insert(personData);
    }
}
