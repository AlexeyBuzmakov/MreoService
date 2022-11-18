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
@Table(name = "type_penalty")
public class TypePenalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_penalty_id")
    private Long id;

    @Column(name = "type_penalty")
    private String type;

    @Column(name = "punishment_penalty")
    private int punishment;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "typePenalty")
    private List<Penalty> penaltyList;
}
