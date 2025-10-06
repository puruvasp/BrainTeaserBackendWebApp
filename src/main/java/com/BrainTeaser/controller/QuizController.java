package com.BrainTeaser.controller;

import com.BrainTeaser.dto.QuizDto;
import com.BrainTeaser.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizes")
@RequiredArgsConstructor
@Tag(name = "Quiz Controller", description = "Endpoints for managing Quiz questions under specific Question Papers")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create/{questionPaperTitle}")
    @Operation(summary = "Create a new Quiz Question for a given Question Paper")
    public ResponseEntity<QuizDto> createQuestion(
            @RequestBody QuizDto quizDto,
            @PathVariable String questionPaperTitle) {

        QuizDto created = quizService.createQuestion(quizDto, questionPaperTitle);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{paperTitle}/{questionText}")
    @Operation(summary = "Get a Quiz Question by its text and Question Paper title")
    public ResponseEntity<QuizDto> getQuestionByText(
            @PathVariable String paperTitle,
            @PathVariable String questionText) {

        QuizDto question = quizService.getQuestionByText(questionText, paperTitle);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all Quiz Questions across all Question Papers")
    public ResponseEntity<List<QuizDto>> getAllQuestions() {
        List<QuizDto> questions = quizService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @PutMapping("/{questionText}")
    @Operation(summary = "Update a Quiz Question by its text")
    public ResponseEntity<QuizDto> updateQuestion(
            @PathVariable String questionText,
            @RequestBody QuizDto quizDto) {

        QuizDto updated = quizService.updateQuestion(questionText, quizDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{questionText}")
    @Operation(summary = "Delete a Quiz Question by its text")
    public ResponseEntity<String> deleteQuestion(@PathVariable String questionText) {
        quizService.deleteQuestion(questionText);
        return ResponseEntity.ok("Question deleted successfully with text: " + questionText);
    }
}
