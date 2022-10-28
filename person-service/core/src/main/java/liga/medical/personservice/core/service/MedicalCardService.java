package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.MedicalCard;

import java.util.List;
import java.util.Optional;

public interface MedicalCardService {

    MedicalCard addMedicalCard(MedicalCard medicalCard);

    void deleteMedicalCard(MedicalCard medicalCard);

    Optional<MedicalCard> getMedicalCardById(Long id);

    MedicalCard editMedicalCard(MedicalCard medicalCard);

    List<MedicalCard> getAll();

}
