package com.BrainTeaser.service.impl;

import com.BrainTeaser.dto.AnswerKeyDto;
import com.BrainTeaser.model.AnswerKey;
import com.BrainTeaser.model.QuestionPaper;
import com.BrainTeaser.repository.AnswerKeyRepository;
import com.BrainTeaser.repository.QuestionPaperRepository;
import com.BrainTeaser.service.AnswerKeyService;
import com.BrainTeaser.util.AnswerKeyUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerKeyServiceImpl implements AnswerKeyService {

    private final AnswerKeyRepository answerKeyRepository;
    private final QuestionPaperRepository questionPaperRepository;
    private final AnswerKeyUtility answerKeyUtility;


    @Override
    public AnswerKeyDto createAnswerKey(AnswerKeyDto answerKeyDTO)
    {
        AnswerKey answerKey = answerKeyUtility.toAnswerKeyEntity(answerKeyDTO);

        AnswerKey savedAnswerKey = answerKeyRepository.save(answerKey);

        return answerKeyUtility.toAnswerKeyDto(savedAnswerKey);
    }


    @Override
    public AnswerKeyDto getAnswerKeyByQuestionPaperTitle(String questionPaperTitle) {
        QuestionPaper questionPaper = questionPaperRepository.findByTitle(questionPaperTitle)
                .orElseThrow(() -> new RuntimeException("QuestionPaper not found with title: " + questionPaperTitle));

        AnswerKey answerKey = (AnswerKey) answerKeyRepository.findByQuestionPaper(questionPaper)
                .orElseThrow(() -> new RuntimeException("AnswerKey not found for QuestionPaper: " + questionPaperTitle));

        return answerKeyUtility.toAnswerKeyDto(answerKey);
    }

    @Override
    public List<AnswerKeyDto> getAllAnswerKeys() {
        List<AnswerKey> allAnswerKeys = answerKeyRepository.findAll();
        List<AnswerKeyDto> result = new ArrayList<>();

        for (AnswerKey ak : allAnswerKeys) {
            result.add(answerKeyUtility.toAnswerKeyDto(ak));
        }

        return result;
    }

    @Override
    public AnswerKeyDto updateAnswerKey(String questionPaperTitle, AnswerKeyDto answerKeyDTO) {
        QuestionPaper questionPaper = questionPaperRepository.findByTitle(questionPaperTitle)
                .orElseThrow(() -> new RuntimeException("QuestionPaper not found with title: " + questionPaperTitle));

        AnswerKey existing = (AnswerKey) answerKeyRepository.findByQuestionPaper(questionPaper)
                .orElseThrow(() -> new RuntimeException("AnswerKey not found for QuestionPaper: " + questionPaperTitle));

        if (answerKeyDTO.getAnswers() != null) {
            existing.setAnswers(answerKeyDTO.getAnswers());
        }

        AnswerKey updated = answerKeyRepository.save(existing);
        return answerKeyUtility.toAnswerKeyDto(updated);
    }

    @Override
    public void deleteAnswerKey(String questionPaperTitle) {
        QuestionPaper questionPaper = questionPaperRepository.findByTitle(questionPaperTitle)
                .orElseThrow(() -> new RuntimeException("QuestionPaper not found with title: " + questionPaperTitle));

        AnswerKey existing = (AnswerKey) answerKeyRepository.findByQuestionPaper(questionPaper)
                .orElseThrow(() -> new RuntimeException("AnswerKey not found for QuestionPaper: " + questionPaperTitle));

        answerKeyRepository.delete(existing);
    }
}
