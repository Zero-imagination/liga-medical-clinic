package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.entity.PersonData;
import liga.medical.personservice.core.service.api.PersonDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person-data")
public class PersonDataController {

    private final PersonDataService personDataService;

    public PersonDataController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping
    public List<PersonData> getAllPersonData() {
        return personDataService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PersonData> getPersonDataById(@PathVariable long id) {
        return personDataService.findById(id);
    }

    @PostMapping
    public PersonData insertPersonData(@RequestBody PersonData personData) {
        return personDataService.save(personData);
    }

}
