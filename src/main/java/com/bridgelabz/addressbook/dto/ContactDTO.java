package com.bridgelabz.addressbook.dto;

import lombok.Data;

public @Data class ContactDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String email;

}
