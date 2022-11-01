package com.example.clientmreo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private String name;
    private String patronymic;
    private String surname;
    private String driverLicense;
    private String brand;
    private String model;
    private Integer yearIssue;
    private String vinNumber;
    private String number;
}
