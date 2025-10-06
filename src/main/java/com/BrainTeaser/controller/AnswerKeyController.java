package com.BrainTeaser.controller;

import com.BrainTeaser.dto.AnswerKeyDto;
import com.BrainTeaser.service.AnswerKeyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer-keys")
@RequiredArgsConstructor
@Tag(name = "Answer Key Controller", description = "Endpoints for managing Answer Keys of Question Papers")
public class AnswerKeyController {

    private final AnswerKeyService answerKeyService;


    @PostMapping("/create")
    @Operation(summary = "Create a new Answer Key")
    public ResponseEntity<AnswerKeyDto> createAnswerKey(@RequestBody AnswerKeyDto answerKeyDto) {
        AnswerKeyDto created = answerKeyService.createAnswerKey(answerKeyDto);
        return ResponseEntity.ok(created);
    }


    @GetMapping("/{questionPaperTitle}")
    @Operation(summary = "Get Answer Key by Question Paper title")
    public ResponseEntity<AnswerKeyDto> getAnswerKeyByQuestionPaperTitle(@PathVariable String questionPaperTitle) {
        AnswerKeyDto answerKey = answerKeyService.getAnswerKeyByQuestionPaperTitle(questionPaperTitle);
        return ResponseEntity.ok(answerKey);
    }


    @GetMapping("/all")
    @Operation(summary = "Get all Answer Keys")
    public ResponseEntity<List<AnswerKeyDto>> getAllAnswerKeys() {
        List<AnswerKeyDto> answerKeys = answerKeyService.getAllAnswerKeys();
        return ResponseEntity.ok(answerKeys);
    }


    @PutMapping("/{questionPaperTitle}")
    @Operation(summary = "Update Answer Key by Question Paper title")
    public ResponseEntity<AnswerKeyDto> updateAnswerKey(
            @PathVariable String questionPaperTitle,
            @RequestBody AnswerKeyDto answerKeyDto) {

        AnswerKeyDto updated = answerKeyService.updateAnswerKey(questionPaperTitle, answerKeyDto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{questionPaperTitle}")
    @Operation(summary = "Delete Answer Key by Question Paper title")
    public ResponseEntity<String> deleteAnswerKey(@PathVariable String questionPaperTitle) {
        answerKeyService.deleteAnswerKey(questionPaperTitle);
        return ResponseEntity.ok("Answer Key deleted successfully for Question Paper: " + questionPaperTitle);
    }
}
