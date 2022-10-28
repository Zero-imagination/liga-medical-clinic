package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getContact() {
        return contactService.getAll();
    }

    @PostMapping
    public void deleteContact(Contact contact) {
        contactService.deleteContact(contact);
    }

    @PostMapping
    public Contact add(Contact contact) {
        return contactService.addContact(contact);
    }

}
