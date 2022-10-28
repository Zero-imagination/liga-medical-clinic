package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.Illness;

import java.util.List;
import java.util.Optional;

public interface IllnessService {

    Illness addIllness(Illness illness);

    void deleteIllness(Illness illness);

    Optional<Illness> getIllnessById(Long id);

    Illness editIllness(Illness illness);

    List<Illness> getAll();

}
