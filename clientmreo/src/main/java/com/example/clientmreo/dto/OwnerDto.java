package com.example.clientmreo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OwnerDto {
    private String name;
    private String surname;
    private String patronymic;
    private String driverLicense;
}
