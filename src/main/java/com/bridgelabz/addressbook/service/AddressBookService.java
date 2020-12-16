package com.bridgelabz.addressbook.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repository.AddressBookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepo addressRepository;

    @Override
    public List<Contact> getAllContacts() {

        return addressRepository.findAll();
    }

    @Override
    public Contact getContactById(long id) {

        Optional<Contact> contactOptional = addressRepository.findById(id);
        if (contactOptional.isEmpty())
            throw new AddressBookException("Contact does not exists!");
        return contactOptional.get();
    }

    @Override
    public Contact addContact(Contact contact) {

        return addressRepository.save(contact);
    }

    @Override
    public boolean updateContactById(long id, ContactDTO contactDTO) {
        Optional<Contact> contactOptional = addressRepository.findById(id);
        if (contactOptional.isEmpty())
            throw new AddressBookException("Contact does not exists!");

        Contact contact = addressRepository.getOne(id);
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setAddress(contactDTO.getAddress());
        contact.setCity(contactDTO.getCity());
        contact.setState(contactDTO.getState());
        contact.setEmail(contactDTO.getEmail());
        contact.setPhone(contactDTO.getPhone());

        addressRepository.save(contact);
        return true;
    }

    @Override
    public boolean deleteContactById(long id) {
        Optional<Contact> contactOptional = addressRepository.findById(id);
        if (contactOptional.isEmpty())
            throw new AddressBookException("Contact does not exists!");

        addressRepository.deleteById(id);
        return true;
    }

}
