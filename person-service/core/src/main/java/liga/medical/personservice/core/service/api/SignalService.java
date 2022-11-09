package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.entity.Signal;

import java.util.List;
import java.util.Optional;

public interface SignalService {

    Signal save(Signal signal);

    Optional<Signal> findById(Long id);

    List<Signal> findAll();

    List<Signal> findAllByPersonDataId(Long personDataId);

}
