package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.IService;
import liga.medical.personservice.core.model.Illness;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/illness")
public class IllnessController {

    private final IService<Illness> illnessService;

    public IllnessController(IService<Illness> illnessService) {
        this.illnessService = illnessService;
    }

    @GetMapping
    public List<Illness> getAllIllnesses() {
        return illnessService.getAll();
    }

    @GetMapping("/{id}")
    public Illness getIllnessById(@PathVariable long id) {
        return illnessService.getById(id);
    }

    @PostMapping
    public Integer insertIllness(@RequestBody Illness illness) {
        return illnessService.insert(illness);
    }
}
