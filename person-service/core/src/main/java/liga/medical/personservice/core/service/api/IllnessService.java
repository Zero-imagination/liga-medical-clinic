package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.entity.Illness;

import java.util.List;
import java.util.Optional;

public interface IllnessService {

    Illness save(Illness illness);

    Optional<Illness> findById(Long id);

    List<Illness> findAll();

}
