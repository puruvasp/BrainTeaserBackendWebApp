package com.BrainTeaser.service.impl;

import com.BrainTeaser.dto.DifficultyDto;
import com.BrainTeaser.model.Difficulty;
import com.BrainTeaser.repository.DifficultyRepository;
import com.BrainTeaser.service.DifficultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DifficultyServiceImpl implements DifficultyService {

    private final DifficultyRepository difficultyRepository;

    private DifficultyDto mapToDto(Difficulty difficulty) {
        return new DifficultyDto(
                difficulty.getDifficultyId(),
                difficulty.getDifficultyName()
        );
    }

    private Difficulty mapToEntity(DifficultyDto dto) {
        Difficulty difficulty = new Difficulty();
        difficulty.setDifficultyId(dto.getDifficultyId());
        difficulty.setDifficultyName(dto.getDifficultyName());
        return difficulty;
    }

    @Override
    public DifficultyDto createDifficulty(DifficultyDto difficultyDto) {
        Difficulty difficulty = mapToEntity(difficultyDto);
        Difficulty saved = difficultyRepository.save(difficulty);
        return mapToDto(saved);
    }

    @Override
    public DifficultyDto getDifficultyById(Long id) {
        Difficulty difficulty = difficultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Difficulty not found with id " + id));
        return mapToDto(difficulty);
    }

    @Override
    public DifficultyDto getDifficultyByName(String difficultyName) {
        Difficulty difficulty = difficultyRepository.findByDifficultyName(difficultyName)
                .orElseThrow(() -> new RuntimeException("Difficulty not found with name " + difficultyName));
        return mapToDto(difficulty);
    }

    @Override
    public List<DifficultyDto> getAllDifficulties() {
        return difficultyRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DifficultyDto updateDifficulty(Long id, DifficultyDto difficultyDto) {
        Difficulty existing = difficultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Difficulty not found with id " + id));

        existing.setDifficultyName(difficultyDto.getDifficultyName());
        Difficulty updated = difficultyRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public DifficultyDto updateDifficultyByName(String difficultyName, DifficultyDto difficultyDto) {
        Difficulty existing = difficultyRepository.findByDifficultyName(difficultyName)
                .orElseThrow(() -> new RuntimeException("Difficulty not found with name " + difficultyName));

        existing.setDifficultyName(difficultyDto.getDifficultyName());
        Difficulty updated = difficultyRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deleteDifficulty(Long id) {
        Difficulty difficulty = difficultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Difficulty not found with id " + id));
        difficultyRepository.delete(difficulty);
    }

    @Override
    public void deleteDifficultyByName(String difficultyName) {
        Difficulty difficulty = difficultyRepository.findByDifficultyName(difficultyName)
                .orElseThrow(() -> new RuntimeException("Difficulty not found with name " + difficultyName));
        difficultyRepository.delete(difficulty);
    }
}
