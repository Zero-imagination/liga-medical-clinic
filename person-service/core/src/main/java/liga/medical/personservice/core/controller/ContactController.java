package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.entity.Contact;
import liga.medical.personservice.core.service.api.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Contact> getContactById(@PathVariable long id) {
        return contactService.findById(id);
    }

    @PostMapping
    public Contact saveContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

}
