package com.example.clientdps.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "penalty")
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_id")
    private Long id;

    @Column(name = "number_car")
    private String number;

    @Column(name = "date_penalty")
    private LocalDate datePenalty;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_penalty_id")
    private TypePenalty typePenalty;
}
