package liga.medical.personservice.core.service;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.api.service.IService;
import liga.medical.personservice.core.model.MedicalCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCardService implements IService<MedicalCard> {

    private final IRepository<MedicalCard> medicalCardRepository;

    public MedicalCardService(IRepository<MedicalCard> medicalCardRepository) {
        this.medicalCardRepository = medicalCardRepository;
    }

    @Override
    public List<MedicalCard> getAll() {
        return medicalCardRepository.getAll();
    }

    @Override
    public MedicalCard getById(long id) {
        return medicalCardRepository.getById(id);
    }

    @Override
    public int insert(MedicalCard medicalCard) {
        return medicalCardRepository.insert(medicalCard);
    }
}
