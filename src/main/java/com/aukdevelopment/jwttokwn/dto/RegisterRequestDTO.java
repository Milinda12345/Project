package com.aukdevelopment.jwttokwn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {

    private String id;
    private String name ;
    private String email ;
    private String username;
    private String password;
}
