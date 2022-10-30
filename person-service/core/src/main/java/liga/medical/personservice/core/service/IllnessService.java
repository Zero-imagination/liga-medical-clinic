package liga.medical.personservice.core.service;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.api.service.IService;
import liga.medical.personservice.core.model.Illness;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessService implements IService<Illness> {

    private final IRepository<Illness> illnessRepository;

    public IllnessService(IRepository<Illness> illnessRepository) {
        this.illnessRepository = illnessRepository;
    }

    @Override
    public List<Illness> getAll() {
        return illnessRepository.getAll();
    }

    @Override
    public Illness getById(long id) {
        return illnessRepository.getById(id);
    }

    @Override
    public int insert(Illness illness) {
        return illnessRepository.insert(illness);
    }
}
