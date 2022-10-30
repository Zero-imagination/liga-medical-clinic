package liga.medical.personservice.core.service;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.api.service.IService;
import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.repository.ContactMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IService<Contact> {

    private final IRepository<Contact> contactRepository;

    public ContactService(ContactMapper contactMapper) {
        this.contactRepository = contactMapper;
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.getAll();
    }

    @Override
    public Contact getById(long id) {
        return contactRepository.getById(id);
    }

    @Override
    public int insert(Contact contact) {
        return contactRepository.insert(contact);
    }
}
