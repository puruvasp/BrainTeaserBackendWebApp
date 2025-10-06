package com.BrainTeaser.repository;

import com.BrainTeaser.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByQuestionPaper_Title(String questionPaperTitle);

    List<Quiz> findByQuestionTextContainingIgnoreCase(String keyword);

    Quiz findByQuestionText(String questionText);
}
