package com.BrainTeaser.repository;

import com.BrainTeaser.model.QuestionPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface QuestionPaperRepository extends JpaRepository<QuestionPaper, Long> {

    List<QuestionPaper> findByTopic_TopicName(String topicName);

    Optional<QuestionPaper> findByTitle(String title);
}
