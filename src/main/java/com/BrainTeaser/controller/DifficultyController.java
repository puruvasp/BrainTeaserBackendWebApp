package com.BrainTeaser.controller;

import com.BrainTeaser.dto.DifficultyDto;
import com.BrainTeaser.service.DifficultyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/difficulties")
@RequiredArgsConstructor
@Tag(name = "Difficulty Controller", description = "Endpoints for managing difficulty levels")
public class DifficultyController {

    private final DifficultyService difficultyService;

    @PostMapping("/create")
    @Operation(summary = "Create a new difficulty level")
    public ResponseEntity<DifficultyDto> createDifficulty(@RequestBody DifficultyDto difficultyDto) {
        DifficultyDto created = difficultyService.createDifficulty(difficultyDto);
        return ResponseEntity.ok(created);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get difficulty by ID")
    public ResponseEntity<DifficultyDto> getDifficultyById(@PathVariable Long id) {
        DifficultyDto difficulty = difficultyService.getDifficultyById(id);
        return ResponseEntity.ok(difficulty);
    }


    @GetMapping("/{difficultyName}")
    @Operation(summary = "Get difficulty by name")
    public ResponseEntity<DifficultyDto> getDifficultyByName(@PathVariable String difficultyName) {
        DifficultyDto difficulty = difficultyService.getDifficultyByName(difficultyName);
        return ResponseEntity.ok(difficulty);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all difficulty levels")
    public ResponseEntity<List<DifficultyDto>> getAllDifficulties() {
        List<DifficultyDto> difficulties = difficultyService.getAllDifficulties();
        return ResponseEntity.ok(difficulties);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update difficulty by ID")
    public ResponseEntity<DifficultyDto> updateDifficulty(@PathVariable Long id, @RequestBody DifficultyDto difficultyDto) {
        DifficultyDto updated = difficultyService.updateDifficulty(id, difficultyDto);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{difficultyName}")
    @Operation(summary = "Update difficulty by name")
    public ResponseEntity<DifficultyDto> updateDifficultyByName(@PathVariable String difficultyName, @RequestBody DifficultyDto difficultyDto) {
        DifficultyDto updated = difficultyService.updateDifficultyByName(difficultyName, difficultyDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete difficulty by ID")
    public ResponseEntity<String> deleteDifficulty(@PathVariable Long id) {
        difficultyService.deleteDifficulty(id);
        return ResponseEntity.ok("Difficulty deleted successfully with ID: " + id);
    }

    @DeleteMapping("/{difficultyName}")
    @Operation(summary = "Delete difficulty by name")
    public ResponseEntity<String> deleteDifficultyByName(@PathVariable String difficultyName) {
        difficultyService.deleteDifficultyByName(difficultyName);
        return ResponseEntity.ok("Difficulty deleted successfully with name: " + difficultyName);
    }
}
