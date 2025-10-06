package com.BrainTeaser.service;

import com.BrainTeaser.dto.DifficultyDto;

import java.util.List;

public interface DifficultyService {

    DifficultyDto createDifficulty(DifficultyDto difficultyDto);

    DifficultyDto getDifficultyById(Long id);

    DifficultyDto getDifficultyByName(String difficultyName);

    List<DifficultyDto> getAllDifficulties();

    DifficultyDto updateDifficulty(Long id, DifficultyDto difficultyDto);

    DifficultyDto updateDifficultyByName(String difficultyName, DifficultyDto difficultyDto);

    void deleteDifficulty(Long id);

    void deleteDifficultyByName(String difficultyName);
}
