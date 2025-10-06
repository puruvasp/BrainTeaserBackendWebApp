package com.BrainTeaser.repository;

import com.BrainTeaser.model.AnswerKey;
import com.BrainTeaser.model.QuestionPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnswerKeyRepository extends JpaRepository<AnswerKey, UUID> {

    Optional<AnswerKey> findByQuestionPaper_Title(String questionPaperTitle);

    Optional<AnswerKey> findByQuestionPaper(QuestionPaper questionPaper);
}