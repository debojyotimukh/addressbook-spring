package com.bridgelabz.addressbook.service;

import java.util.List;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

import org.springframework.stereotype.Service;

@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<Contact> getAllContacts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Contact getContactById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Contact addContact(Contact contact) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean updateContactById(long id, ContactDTO contactDTO) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteContactById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
