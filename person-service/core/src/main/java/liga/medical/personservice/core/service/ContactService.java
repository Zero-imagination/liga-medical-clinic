package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.Contact;

import java.util.List;

public interface ContactService {

    Contact addContact(Contact contact);

    void deleteContact(Contact id);

    Contact getByEmailContact(String name);

    Contact editContact(Contact contact);

    List<Contact> getAll();

}
