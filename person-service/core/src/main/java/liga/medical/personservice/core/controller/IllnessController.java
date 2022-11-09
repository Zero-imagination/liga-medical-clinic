package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.entity.Illness;
import liga.medical.personservice.core.service.api.IllnessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/illness")
public class IllnessController {

    private final IllnessService illnessService;

    public IllnessController(IllnessService illnessService) {
        this.illnessService = illnessService;
    }

    @GetMapping
    public List<Illness> getAllIllnesses() {
        return illnessService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Illness> getIllnessById(@PathVariable long id) {
        return illnessService.findById(id);
    }

    @PostMapping
    public Illness saveIllness(@RequestBody Illness illness) {
        return illnessService.save(illness);
    }
}
