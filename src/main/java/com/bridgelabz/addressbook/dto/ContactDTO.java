package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class ContactDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}", message = "Invalid first name!")
    private String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}", message = "Invalid first name!")
    private String lastName;

    @Pattern(regexp = "^[0-9\\s\\,]+[\\w]{3,}.+$", message = "Invalid address!")
    private String address;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}", message = "Invalid city!")
    private String city;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}", message = "Invalid state!")
    private String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "Invalid zip code!")
    private String zip;

    @Pattern(regexp = "^([+]{1})??([0-9]{2})??([0-9]{10})$", message = "Invalid phone number!")
    private String phone;

    @Pattern(regexp = "^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", message = "Invalid email address!")
    private String email;

}
