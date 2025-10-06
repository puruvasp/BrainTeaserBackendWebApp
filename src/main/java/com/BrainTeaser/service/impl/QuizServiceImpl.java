package com.BrainTeaser.service.impl;

import com.BrainTeaser.service.QuizService;
import com.BrainTeaser.dto.QuizDto;
import com.BrainTeaser.model.Quiz;
import com.BrainTeaser.model.QuestionPaper;
import com.BrainTeaser.repository.QuestionPaperRepository;
import com.BrainTeaser.repository.QuizRepository;
import com.BrainTeaser.util.QuestionPaperUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository questionRepository;
    private final QuestionPaperRepository questionPaperRepository;
    private final QuestionPaperUtility questionPaperUtility;

    @Override
    public QuizDto createQuestion(QuizDto quizDto,String questionPaperTitle) {

        // 1. Created Lookup For Question By QuestionTitle
        Optional<QuestionPaper> questionPaperOptional = questionPaperRepository.findByTitle(questionPaperTitle);

        // 2. If Question Paper Not Found Throw Error
        if (questionPaperOptional.isEmpty()) {
            throw new RuntimeException("QuestionPaper not found with title: " + questionPaperTitle);
        }

        // 3. Create Question
        Quiz quiz = new Quiz();
        quiz.setQuestionText(quizDto.getQuestionText());
        quiz.setOptionA(quizDto.getOptionA());
        quiz.setOptionB(quizDto.getOptionB());
        quiz.setOptionC(quizDto.getOptionC());
        quiz.setOptionD(quizDto.getOptionD());
        quiz.setQuestionPaper(questionPaperOptional.get());

        // Saving The Object
        Quiz saved = questionRepository.save(quiz);
        var savedQuestionPaper = saved.getQuestionPaper();

        QuizDto dto = new QuizDto();
        dto.setQuestionId(saved.getQuestionId());
        dto.setQuestionText(saved.getQuestionText());
        dto.setOptionA(saved.getOptionA());
        dto.setOptionB(saved.getOptionB());
        dto.setOptionC(saved.getOptionC());
        dto.setOptionD(saved.getOptionD());
        dto.setQuestionPaperDto(questionPaperUtility.toQuestionPaperDto(savedQuestionPaper));

        return dto;
    }

    @Override
    public QuizDto getQuestionByText(String questionText, String paperTitle) {

        Optional<Quiz> qOpt = Optional.ofNullable(questionRepository.findByQuestionText(questionText));
        if (qOpt.isEmpty()) {
            throw new RuntimeException("Question not found with text: " + questionText);
        }

        Quiz q = qOpt.get();
        QuizDto dto = new QuizDto();
        dto.setQuestionId(q.getQuestionId());
        dto.setQuestionText(q.getQuestionText());
        dto.setOptionA(q.getOptionA());
        dto.setOptionB(q.getOptionB());
        dto.setOptionC(q.getOptionC());
        dto.setOptionD(q.getOptionD());
        dto.setQuestionPaperDto(questionPaperUtility.toQuestionPaperDto(q.getQuestionPaper()));

        return dto;
    }

    @Override
    public List<QuizDto> getAllQuestions() {
        List<Quiz> allQuestions = questionRepository.findAll();
        List<QuizDto> result = new ArrayList<>();

        for (Quiz q : allQuestions) {
            QuizDto dto = new QuizDto();
            dto.setQuestionId(q.getQuestionId());
            dto.setQuestionText(q.getQuestionText());
            dto.setOptionA(q.getOptionA());
            dto.setOptionB(q.getOptionB());
            dto.setOptionC(q.getOptionC());
            dto.setOptionD(q.getOptionD());
            dto.setQuestionPaperDto(questionPaperUtility.toQuestionPaperDto(q.getQuestionPaper()));
            result.add(dto);
        }

        return result;
    }

    @Override
    public QuizDto updateQuestion(String questionText, QuizDto quizDto) {
        Optional<Quiz> qOpt = Optional.ofNullable(questionRepository.findByQuestionText(questionText));
        if (qOpt.isEmpty()) {
            throw new RuntimeException("Question not found with text: " + questionText);
        }

        Quiz existing = qOpt.get();

        if (quizDto.getQuestionText() != null) existing.setQuestionText(quizDto.getQuestionText());
        if (quizDto.getOptionA() != null) existing.setOptionA(quizDto.getOptionA());
        if (quizDto.getOptionB() != null) existing.setOptionB(quizDto.getOptionB());
        if (quizDto.getOptionC() != null) existing.setOptionC(quizDto.getOptionC());
        if (quizDto.getOptionD() != null) existing.setOptionD(quizDto.getOptionD());
        if (quizDto.getQuestionPaperDto() != null) {
            Optional<QuestionPaper> qpOpt = questionPaperRepository.findById(quizDto.getQuestionPaperDto().getQuestionPaperId());
            if (qpOpt.isEmpty()) {
                throw new RuntimeException("QuestionPaper not found with id: " + quizDto.getQuestionPaperDto().getQuestionPaperId());
            }
            existing.setQuestionPaper(qpOpt.get());
        }

        Quiz updated = questionRepository.save(existing);

        QuizDto dto = new QuizDto();
        dto.setQuestionId(updated.getQuestionId());
        dto.setQuestionText(updated.getQuestionText());
        dto.setOptionA(updated.getOptionA());
        dto.setOptionB(updated.getOptionB());
        dto.setOptionC(updated.getOptionC());
        dto.setOptionD(updated.getOptionD());

        dto.setQuestionPaperDto(
                questionPaperUtility.toQuestionPaperDto(
                        updated.getQuestionPaper()
                )
        );

        return dto;
    }

    @Override
    public void deleteQuestion(String questionText) {
        Optional<Quiz> qOpt = Optional.ofNullable(questionRepository.findByQuestionText(questionText));
        if (qOpt.isEmpty()) {
            throw new RuntimeException("Question not found with text: " + questionText);
        }

        questionRepository.delete(qOpt.get());
    }
}
