package liga.medical.personservice.core.impl;

import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.core.service.MedicalCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;

    public MedicalCardServiceImpl(MedicalCardRepository medicalCardRepository) {
        this.medicalCardRepository = medicalCardRepository;
    }

    @Override
    public MedicalCard addMedicalCard(MedicalCard medicalCard) {
        return medicalCardRepository.saveAndFlush(medicalCard);
    }

    @Override
    public void deleteMedicalCard(MedicalCard medicalCard) {
        medicalCardRepository.delete(medicalCard);
    }

    @Override
    public Optional<MedicalCard> getMedicalCardById(Long id) {
        return medicalCardRepository.findById(id);
    }

    @Override
    public MedicalCard editMedicalCard(MedicalCard medicalCard) {
        return medicalCardRepository.saveAndFlush(medicalCard);
    }

    @Override
    public List<MedicalCard> getAll() {
        return medicalCardRepository.findAll();
    }
}
