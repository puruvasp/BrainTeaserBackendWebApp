package com.BrainTeaser.dto;

import com.BrainTeaser.model.QuestionPaper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "DTO representing the Answer Key for a Question Paper")
public class AnswerKeyDto {

    @Schema(
            description = "Unique identifier for the Answer Key",
            example = "123e4567-e89b-12d3-a456-426614174000"
    )
    private Long answerKeyId;
    @Schema(
            description = "Mapping of question number to the correct option.",
            example = "{\"1\": \"A\", \"2\": \"C\", \"3\": \"True\"}"
    )
    private Map<Integer, String> answers = new HashMap<>();

    @Schema(
            description = "The Question Paper associated with this Answer Key",
            implementation = QuestionPaper.class
    )
    private QuestionPaperDto questionPaperDto;
}
