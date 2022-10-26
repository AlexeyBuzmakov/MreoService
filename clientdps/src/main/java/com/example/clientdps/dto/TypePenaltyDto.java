package com.example.clientdps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypePenaltyDto {
    private String type;
    private int punishment;
    private List<PenaltyDto>penaltyDtoList;
}
