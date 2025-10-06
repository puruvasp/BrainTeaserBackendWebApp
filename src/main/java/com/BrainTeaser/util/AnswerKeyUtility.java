package com.BrainTeaser.util;

import com.BrainTeaser.dto.AnswerKeyDto;
import com.BrainTeaser.model.AnswerKey;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerKeyUtility {

    public abstract AnswerKey toAnswerKeyEntity(AnswerKeyDto answerKeyDto);
    public abstract AnswerKeyDto toAnswerKeyDto(AnswerKey answerKey);

}
