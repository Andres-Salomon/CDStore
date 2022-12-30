package com.example.CDStore.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDto {
    private String firstName;
    private String lastName;
    private String dob;
    private String address;

    private String zipCode;
}
