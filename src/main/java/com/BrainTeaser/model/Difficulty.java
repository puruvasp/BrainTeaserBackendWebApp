package com.BrainTeaser.model;

import jakarta.persistence. *;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Difficulty extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long difficultyId;

    @Column(name = "difficulty_name", nullable = false)
    private String difficultyName;

}
