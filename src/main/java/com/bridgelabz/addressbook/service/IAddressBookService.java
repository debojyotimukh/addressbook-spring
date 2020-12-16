package com.bridgelabz.addressbook.service;

import java.util.List;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

public interface IAddressBookService {

    public List<Contact> getAllContacts();

    public Contact getContactById(long id);

    public Contact addContact(Contact contact);

    public boolean updateContactById(long id, ContactDTO contactDTO);

    public boolean deleteContactById(long id);

}
