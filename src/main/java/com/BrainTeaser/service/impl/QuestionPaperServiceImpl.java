package com.BrainTeaser.service.impl;

import com.BrainTeaser.service.QuestionPaperService;
import com.BrainTeaser.dto.QuestionPaperDto;
import com.BrainTeaser.model.Quiz;
import com.BrainTeaser.model.QuestionPaper;
import com.BrainTeaser.model.Topic;
import com.BrainTeaser.repository.QuestionPaperRepository;
import com.BrainTeaser.repository.QuizRepository;
import com.BrainTeaser.repository.TopicRepository;
import com.BrainTeaser.util.QuestionPaperUtility;
import com.BrainTeaser.util.QuizUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionPaperServiceImpl implements QuestionPaperService {

    private final QuestionPaperRepository questionPaperRepository;
    private final TopicRepository topicRepository;
    private final QuizRepository quizRepository;
    private final QuestionPaperUtility questionPaperUtility;
    private final QuizUtility  quizUtility;

    @Override
    @Transactional
    public QuestionPaperDto createQuestionPaper(QuestionPaperDto questionPaperDto) {

        Optional<Topic> topicOptional = topicRepository.findByTopicName(questionPaperDto.getTopicDto().getTopicName());
        if (!topicOptional.isPresent()) {
            throw new RuntimeException("Topic not found with name: " + questionPaperDto.getTopicDto().getTopicName());
        }

        Topic topic = topicOptional.get();

        QuestionPaper questionPaper = questionPaperUtility.toQuestionPaperEntity(questionPaperDto);
        questionPaper.setTopic(topic); // Set the actual Topic entity

        QuestionPaper savedQuestionPaper = questionPaperRepository.save(questionPaper);

        return questionPaperUtility.toQuestionPaperDto(savedQuestionPaper);
    }


    @Override
    public QuestionPaperDto getQuestionPaperByTitle(String title) {

        Optional<QuestionPaper> questionPaperOptional = questionPaperRepository.findByTitle(title);

        if (!questionPaperOptional.isPresent()) {
            throw new RuntimeException("Question Paper not found with title: " + title);
        }

        QuestionPaper questionPaper = questionPaperOptional.get();
        return questionPaperUtility.toQuestionPaperDto(questionPaper);
    }



    @Override
    public List<QuestionPaperDto> getAllQuestionPapers() {
        // Fetch all QuestionPaper entities
        List<QuestionPaper> questionPapers = questionPaperRepository.findAll();

        // Map each entity to DTO
        List<QuestionPaperDto> dtoList = new ArrayList<>();
        for (QuestionPaper qp : questionPapers) {
            dtoList.add(questionPaperUtility.toQuestionPaperDto(qp));
        }

        return dtoList;
    }

    @Override
    @Transactional
    public QuestionPaperDto updateQuestionPaperByTitle(String title, QuestionPaperDto dto) {
        Optional<QuestionPaper> optionalQuestionPaper = questionPaperRepository.findByTitle(title);
        if (!optionalQuestionPaper.isPresent()) {
            throw new RuntimeException("Question Paper not found with title: " + title);
        }
//
        QuestionPaper existingQuestionPaper = optionalQuestionPaper.get();
//
//        existingQuestionPaper.setTitle(dto.getTitle());
//
//        existingQuestionPaper.setQuestions(questionUtility.toQuestionEntity(dto.getQuestions()));
//
//        Optional<Topic> topicOptional = topicRepository.findByTopic_TopicName(dto.getTopicDTO().getTopicName());
//        if (!topicOptional.isPresent()) {
//            throw new RuntimeException("Topic not found with name: " + dto.getTopicDTO().getTopicName());
//        }
//        existingQuestionPaper.setTopic(topicOptional.get());
//
        QuestionPaper updatedQuestionPaper = questionPaperRepository.save(existingQuestionPaper);
//
        return questionPaperUtility.toQuestionPaperDto(updatedQuestionPaper);
    }



    @Override
    public void deleteQuestionPaper(String title) {
        Optional<QuestionPaper> qpOpt = questionPaperRepository.findByTitle(title);
        if (!qpOpt.isPresent()) {
            throw new RuntimeException("QuestionPaper not found with title: " + title);
        }

        questionPaperRepository.delete(qpOpt.get());
    }
}
