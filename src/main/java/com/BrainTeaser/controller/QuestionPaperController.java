package com.BrainTeaser.controller;

import com.BrainTeaser.dto.QuestionPaperDto;
import com.BrainTeaser.service.QuestionPaperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question-papers")
@RequiredArgsConstructor
@Tag(name = "Question Paper Controller", description = "Endpoints for managing Question Papers")
public class QuestionPaperController {

    private final QuestionPaperService questionPaperService;

    @PostMapping("/create")
    @Operation(summary = "Create a new Question Paper")
    public ResponseEntity<QuestionPaperDto> createQuestionPaper(@RequestBody QuestionPaperDto questionPaperDto) {
        QuestionPaperDto created = questionPaperService.createQuestionPaper(questionPaperDto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{title}")
    @Operation(summary = "Get Question Paper by Title")
    public ResponseEntity<QuestionPaperDto> getQuestionPaperByTitle(@PathVariable String title) {
        QuestionPaperDto questionPaper = questionPaperService.getQuestionPaperByTitle(title);
        return ResponseEntity.ok(questionPaper);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all Question Papers")
    public ResponseEntity<List<QuestionPaperDto>> getAllQuestionPapers() {
        List<QuestionPaperDto> questionPapers = questionPaperService.getAllQuestionPapers();
        return ResponseEntity.ok(questionPapers);
    }

    @PutMapping("/{title}")
    @Operation(summary = "Update Question Paper by Title")
    public ResponseEntity<QuestionPaperDto> updateQuestionPaperByTitle(
            @PathVariable String title,
            @RequestBody QuestionPaperDto questionPaperDto) {

        QuestionPaperDto updated = questionPaperService.updateQuestionPaperByTitle(title, questionPaperDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{title}")
    @Operation(summary = "Delete Question Paper by Title")
    public ResponseEntity<String> deleteQuestionPaper(@PathVariable String title) {
        questionPaperService.deleteQuestionPaper(title);
        return ResponseEntity.ok("Question Paper deleted successfully with title: " + title);
    }
}
