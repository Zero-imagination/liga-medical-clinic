package liga.medical.personservice.core.service;

import liga.medical.personservice.core.entity.Illness;
import liga.medical.personservice.core.repository.IllnessRepository;
import liga.medical.personservice.core.service.api.IllnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IllnessServiceImpl implements IllnessService {
    private final IllnessRepository illnessRepository;

    @Override
    public Illness save(Illness illness) {
        return illnessRepository.save(illness);
    }

    @Override
    public Optional<Illness> findById(Long id) {
        return illnessRepository.findById(id);
    }

    @Override
    public List<Illness> findAll() {
        return illnessRepository.findAll();
    }
}
