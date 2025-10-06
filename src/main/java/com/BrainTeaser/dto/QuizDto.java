package com.BrainTeaser.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "DTO representing a Question")
public class QuizDto {

    @Schema(
            description = "Unique identifier of the question",
            example = "123e4567-e89b-12d3-a456-426614174000"
    )
    private Long questionId;

    @Schema(
            description = "The text of the question",
            example = "What is the capital of France?"
    )
    private String questionText;

    @Schema(
            description = "Option A for the question",
            example = "Paris"
    )
    private String optionA;

    @Schema(
            description = "Option B for the question",
            example = "London"
    )
    private String optionB;

    @Schema(
            description = "Option C for the question",
            example = "Berlin"
    )
    private String optionC;

    @Schema(
            description = "Option D for the question",
            example = "Madrid"
    )
    private String optionD;

    @Schema(
            description = "The Question Paper this question belongs to",
            implementation = QuestionPaperDto.class
    )
    private QuestionPaperDto questionPaperDto;

}
