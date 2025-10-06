package com.BrainTeaser.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class AnswerKey extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerKeyId;

    @ElementCollection
    @CollectionTable(name = "answer_key_mapping",
            joinColumns = @JoinColumn(name = "answer_key_id"))

    @MapKeyColumn(name = "question_number")
    @Column(name = "correct_option")
    private Map<Integer, String> answers = new HashMap<>();

    @OneToOne
    @JoinColumn(name = "question_paper_id", nullable = false)
    private QuestionPaper questionPaper;

}
