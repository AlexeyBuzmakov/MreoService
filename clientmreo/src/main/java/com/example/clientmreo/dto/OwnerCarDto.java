package com.example.clientmreo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerCarDto {
    @Pattern(regexp = "[A-Z][a-z]+", message = "Name can only contain letters, the first letter must be capitalized")
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters")
    private String name;

    @Pattern(regexp = "[A-Z][a-z]+", message = "Patronymic can only contain letters, the first letter must be capitalized")
    @Size(min = 2, max = 15, message = "Patronymic must be between 2 and 15 characters")
    private String patronymic;

    @Pattern(regexp = "[A-Z][a-z]+", message = "Surname can only contain letters, the first letter must be capitalized")
    @Size(min = 2, max = 15, message = "Surname must be between 2 and 15 characters")
    private String surname;

    @Pattern(regexp = "[A-Z]{2}\\d{3}[A-Z]{3}", message = "Driver's license number is incorrect")
    private String driverLicense;

    @NotNull(message = "Brand cannot be null")
    @NotBlank(message = "Brand cannot be empty or blank")
    private String brand;

    @NotNull(message = "Brand cannot be null")
    @NotBlank(message = "Brand cannot be empty or blank")
    private String model;

    @Min(value = 1950, message = "Year of manufacture cannot be less than 1950")
    @Max(value = 2022, message = "Year of issue cannot be greater than the current")
    private Integer yearIssue;

    @Pattern(regexp = "\\d{2}[A-Z]{3}\\d{3}[A-Z]{3}", message = "Vin number is incorrect")
    private String vinNumber;

    @Pattern(regexp = "[A-Z]\\d{3}[A-Z]{2}", message = "Car number is incorrect")
    private String number;
}
