package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.IService;
import liga.medical.personservice.core.model.MedicalCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medical-card")
public class MedicalCardController {

    private final IService<MedicalCard> medicalCardService;

    public MedicalCardController(IService<MedicalCard> medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @GetMapping
    public List<MedicalCard> getAll() {
        return medicalCardService.getAll();
    }

    @GetMapping("/{id}")
    public MedicalCard getMedicalCardById(@PathVariable long id) {
        return medicalCardService.getById(id);
    }

    @PostMapping
    public int insertMedicalCard(@RequestBody MedicalCard medicalCard) {
        return medicalCardService.insert(medicalCard);
    }

}
