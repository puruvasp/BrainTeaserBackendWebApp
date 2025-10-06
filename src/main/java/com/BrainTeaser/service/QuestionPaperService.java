package com.BrainTeaser.service;

import com.BrainTeaser.dto.QuestionPaperDto;
import java.util.List;

public interface QuestionPaperService {
    public abstract QuestionPaperDto createQuestionPaper(QuestionPaperDto questionPaperDTO);
    public abstract QuestionPaperDto getQuestionPaperByTitle(String title);
    public abstract List<QuestionPaperDto> getAllQuestionPapers();
    public abstract QuestionPaperDto updateQuestionPaperByTitle(String title, QuestionPaperDto dto);
    public abstract void deleteQuestionPaper(String title);
}
