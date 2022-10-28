package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.service.PersonDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RestController
@RequestMapping("/person-data")
public class PersonDataController {
    private final PersonDataService personDataService;

    public PersonDataController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping
    public void get() {
        personDataService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<PersonData> getPersonDataById(@PathVariable long id) {
        return personDataService.getPersonDataById(id);
    }

    @PostMapping
    public PersonData add(@RequestBody PersonData personData) {
        return personDataService.addPersonData(personData);
    }

}
