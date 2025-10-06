package com.BrainTeaser.util;

import com.BrainTeaser.dto.QuizDto;
import com.BrainTeaser.model.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizUtility {

    public abstract Quiz toQuizEntity(QuizDto quizDto);
    public abstract QuizDto toQuizDto(Quiz quiz);

}
