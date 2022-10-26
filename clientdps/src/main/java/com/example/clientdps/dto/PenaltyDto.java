package com.example.clientdps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PenaltyDto {
    private String number;
    private LocalDate datePenalty;
    private TypePenaltyDto typePenaltyDto;
}
