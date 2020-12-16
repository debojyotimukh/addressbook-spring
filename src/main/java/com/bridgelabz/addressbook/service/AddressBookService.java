package com.bridgelabz.addressbook.service;

import java.util.List;

import com.bridgelabz.addressbook.dto.ContactDTO;
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
        // TODO exception if not present
        return addressRepository.findById(id).get();
    }

    @Override
    public Contact addContact(Contact contact) {

        return addressRepository.save(contact);
    }

    @Override
    public boolean updateContactById(long id, ContactDTO contactDTO) {
        // TODO exception if not present
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
        // TODO exception if not present
        addressRepository.deleteById(id);
        return true;
    }

}
