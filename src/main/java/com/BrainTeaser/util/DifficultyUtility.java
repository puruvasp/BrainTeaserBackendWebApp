package com.BrainTeaser.util;

import com.BrainTeaser.dto.DifficultyDto;
import com.BrainTeaser.model.Difficulty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DifficultyUtility {

    public abstract Difficulty toDifficultyEntity(DifficultyDto difficultyDto);
    public abstract DifficultyDto toDifficultyDto(Difficulty difficulty);

}
