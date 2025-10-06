package com.BrainTeaser.service;

import com.BrainTeaser.dto.QuizDto;
import java.util.List;

public interface QuizService {
    public abstract QuizDto createQuestion(QuizDto quizDto, String title);
    public abstract QuizDto getQuestionByText(String questionText, String paperTitle);
    public abstract List<QuizDto> getAllQuestions();
    public abstract QuizDto updateQuestion(String questionText, QuizDto quizDto);
    public abstract void deleteQuestion(String questionText);
}
