package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.entity.Signal;
import liga.medical.personservice.core.service.api.SignalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/signals")
public class SignalController {

    private final SignalService signalService;

    public SignalController(SignalService signalService) {
        this.signalService = signalService;
    }

    @GetMapping
    public List<Signal> getAllSignal() {
        return signalService.findAll();
    }

    @GetMapping("/{personDataId}")
    public List<Signal> getAllSignalByPersonDataId(@PathVariable long personDataId) {
        return signalService.findAllByPersonDataId(personDataId);
    }

    @PostMapping
    public Signal save(@RequestBody Signal signal) {
        return signalService.save(signal);
    }
}
