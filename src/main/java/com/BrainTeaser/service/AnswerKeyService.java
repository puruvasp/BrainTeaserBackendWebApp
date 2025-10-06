package com.BrainTeaser.service;

import com.BrainTeaser.dto.AnswerKeyDto;
import java.util.List;

public interface AnswerKeyService {
    public abstract AnswerKeyDto createAnswerKey(AnswerKeyDto answerKeyDTO);
    public abstract AnswerKeyDto getAnswerKeyByQuestionPaperTitle(String questionPaperTitle);
    public abstract List<AnswerKeyDto> getAllAnswerKeys();
    public abstract AnswerKeyDto updateAnswerKey(String questionPaperTitle, AnswerKeyDto answerKeyDTO);
    public abstract void deleteAnswerKey(String questionPaperTitle);
}
