package com.bridgelabz.addressbook.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.service.IAddressBookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(controllers = AddressBookController.class)
public class AddressBookControllerTest {

    @MockBean
    private IAddressBookService addressBookService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AddressBookController()).build();
    }

    @Test
    @DisplayName("Should list all contacts when GET call made")
    public void givenContacts_whenGetCalled_shouldReturnContactList() throws Exception {
        Contact contact1 = new Contact(1l, "Peter", "Parker", "gjfg kfg", "Howrah", "West Bengal", "4578963780",
                "hjdfhd@gmail.com");
        Contact contact2 = new Contact(2l, "Stephen", "Strange", "kkml", "Bengaluru", "Karnataka", "7894561230",
                "tyu.gfg@gmail.co.in");

        Mockito.when(addressBookService.getAllContacts()).thenReturn(Arrays.asList(contact1, contact2));

        mockMvc.perform(get("/addressbookservice/")).andExpect(status().isOk());

    }
}
