package liga.medical.personservice.core.service;

import liga.medical.personservice.core.entity.Signal;
import liga.medical.personservice.core.repository.SignalsRepository;
import liga.medical.personservice.core.service.api.SignalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignalServiceImpl implements SignalService {

    private final SignalsRepository signalsRepository;

    @Override
    public Signal save(Signal signal) {
        return signalsRepository.save(signal);
    }

    @Override
    public Optional<Signal> findById(Long id) {
        return signalsRepository.findById(id);
    }

    @Override
    public List<Signal> findAll() {
        return signalsRepository.findAll();
    }

    @Override
    public List<Signal> findAllByPersonDataId(Long personDataId) {
        return signalsRepository.findAllByPersonDataId(personDataId);
    }
}
