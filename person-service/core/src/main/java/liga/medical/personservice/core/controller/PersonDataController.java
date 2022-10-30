package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.IService;
import liga.medical.personservice.core.model.PersonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person-data")
public class PersonDataController {

    private final IService<PersonData> personDataService;

    public PersonDataController(IService<PersonData> personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping
    public List<PersonData> getAllPersonData() {
        return personDataService.getAll();
    }

    @GetMapping("/{id}")
    public PersonData getPersonDataById(@PathVariable long id) {
        return personDataService.getById(id);
    }

    @PostMapping
    public Integer insertPersonData(@RequestBody PersonData personData) {
        return personDataService.insert(personData);
    }

}
