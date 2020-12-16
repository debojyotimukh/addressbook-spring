package com.bridgelabz.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.service.IAddressBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/addressbookservice")
@CrossOrigin(origins = { "http://127.0.0.1:5500", "http://localhost:3000" })
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping(value = { "", "/", "/contacts" })
    public ResponseEntity<ResponseDTO> getAllContacts() {
        List<Contact> contactList = addressBookService.getAllContacts();
        ResponseDTO responseDTO = new ResponseDTO("Get call sucessful", contactList);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "contacts/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable("id") long Id) {
        Contact contact = addressBookService.getContactById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get call sucessful", contact);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "add/")
    public ResponseEntity<ResponseDTO> newContact(@Valid @RequestBody ContactDTO contactDTO) {
        Contact contact = addressBookService.addContact(new Contact(contactDTO));
        ResponseDTO responseDTO = new ResponseDTO("Add contact sucessful", contact);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<ResponseDTO> updateContactById(@PathVariable("id") Long id,
            @RequestBody ContactDTO contactDTO) {
        addressBookService.updateContactById(id, contactDTO);
        Contact updatedContact = addressBookService.getContactById(id);
        ResponseDTO responseDTO = new ResponseDTO("Contact update sucessful", updatedContact);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContactById(@PathVariable("id") long id) {
        Contact contact = addressBookService.getContactById(id);
        addressBookService.deleteContactById(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete contact sucessful", contact);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
