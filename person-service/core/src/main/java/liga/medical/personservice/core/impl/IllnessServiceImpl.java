package liga.medical.personservice.core.impl;

import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.repository.IllnessRepository;
import liga.medical.personservice.core.service.IllnessService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IllnessServiceImpl implements IllnessService {

    private final IllnessRepository illnessRepository;

    public IllnessServiceImpl(IllnessRepository illnessRepository) {
        this.illnessRepository = illnessRepository;
    }

    @Override
    public Illness addIllness(Illness illness) {
        return illnessRepository.saveAndFlush(illness);
    }

    @Override
    public void deleteIllness(Illness illness) {
        illnessRepository.delete(illness);
    }

    @Override
    public Optional<Illness> getIllnessById(Long id) {
        return illnessRepository.findById(id);
    }

    @Override
    public Illness editIllness(Illness illness) {
        return illnessRepository.saveAndFlush(illness);
    }

    @Override
    public List<Illness> getAll() {
        return illnessRepository.findAll();
    }
}
