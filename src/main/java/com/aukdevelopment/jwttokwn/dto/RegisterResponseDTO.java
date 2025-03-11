package com.aukdevelopment.jwttokwn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterResponseDTO {
    private String message;
    private String error;
}
