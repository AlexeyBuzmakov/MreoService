package com.example.clientdps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "type_penalty_table")
public class TypePenaltyEntity {
    @Id
    @SequenceGenerator(name="type_penalty_tableSequence", sequenceName="type_penalty_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="type_penalty_tableSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "type_penalty")
    private String type;

    @Column(name = "punishment_penalty")
    private int punishment;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "typePenaltyEntity")
    private List<PenaltyEntity> penaltyEntityList;
}
