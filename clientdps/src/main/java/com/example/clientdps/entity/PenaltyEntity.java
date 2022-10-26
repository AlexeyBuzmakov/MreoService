package com.example.clientdps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "penalty_table")
public class PenaltyEntity {
    @Id
    @SequenceGenerator(name="penalty_tableSequence", sequenceName="penalty_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="penalty_tableSequence")
    @Column(name = "car_id", nullable = false)
    private Long id;

    @Column(name = "number_car")
    private String number;

    @Column(name = "date_penalty")
    private LocalDate datePenalty;

    @ManyToOne
    @JoinColumn(name = "penalty_id")
    private TypePenaltyEntity typePenaltyEntity;
}
