package com.BrainTeaser.util;

import com.BrainTeaser.dto.QuestionPaperDto;
import com.BrainTeaser.model.QuestionPaper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionPaperUtility {

    public abstract QuestionPaper toQuestionPaperEntity(QuestionPaperDto questionPaperDto);
    public abstract QuestionPaperDto toQuestionPaperDto(QuestionPaper questionPaper);

}
