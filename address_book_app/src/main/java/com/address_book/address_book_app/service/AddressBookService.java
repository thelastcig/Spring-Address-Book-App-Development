package com.address_book.address_book_app.service;


import com.address_book.address_book_app.model.AddressBookEntry;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    private final List<AddressBookEntry> contacts = new ArrayList<>();
    private Long nextId = 1L;

    public List<AddressBookEntry> getAllContacts() {
        return contacts;
    }

    public Optional<AddressBookEntry> getContactById(Long id) {
        return contacts.stream().filter(contact -> contact.getId().equals(id)).findFirst();
    }

    public AddressBookEntry addContact(AddressBookEntry contact) {
        contact.setId(nextId++);
        contacts.add(contact);
        return contact;
    }

    public Optional<AddressBookEntry> updateContact(Long id, AddressBookEntry updatedContact) {
        return getContactById(id).map(existingContact -> {
            existingContact.setName(updatedContact.getName());
            existingContact.setEmail(updatedContact.getEmail());
            existingContact.setPhone(updatedContact.getPhone());
            return existingContact;
        });
    }

    public boolean deleteContact(Long id) {
        return contacts.removeIf(contact -> contact.getId().equals(id));
    }
}
