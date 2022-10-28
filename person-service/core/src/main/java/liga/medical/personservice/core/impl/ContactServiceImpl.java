package liga.medical.personservice.core.impl;

import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.repository.ContactRepository;
import liga.medical.personservice.core.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    @Override
    public void deleteContact(Contact id) {
        contactRepository.delete(id);
    }

    @Override
    public Contact getByEmailContact(String name) {
        return contactRepository.findByEmail(name);
    }

    @Override
    public Contact editContact(Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
}
