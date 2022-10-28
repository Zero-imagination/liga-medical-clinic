package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.MedicalCardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/medical-card")
public class MedicalCardController {
    private final MedicalCardService medicalCardService;

    public MedicalCardController(MedicalCardService medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @PostMapping
    public MedicalCard add(@RequestBody MedicalCard medicalCard) {
        return medicalCardService.addMedicalCard(medicalCard);
    }

    @GetMapping
    public void get() {
        medicalCardService.getAll();
    }
}
