package com.BrainTeaser.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(name = "QuestionPaperDTO",
        description = "DTO representing a Question Paper. Contains metadata, topic, " +
                        "list of questions, and the associated answer key.")
public class QuestionPaperDto {

        @Schema(
                description = "Unique identifier for the question paper",
                example = "1"
        )
        private Long questionPaperId;

        @Schema(
                description = "Title of the question paper",
                example = "General Knowledge Test - 2025"
        )
        private String title;

        @Schema(
                description = "Topic associated with the question paper",
                implementation = TopicDto.class
        )
        private TopicDto topicDto;

        @Schema(
                description = "Set of questions included in the question paper",
                implementation = QuizDto.class,
                example = "[{\"questionId\":\"111e4567-e89b-12d3-a456-426614174000\",\"questionText\":\"What is 2+2?\",\"optionA\":\"3\",\"optionB\":\"4\",\"optionC\":\"5\",\"optionD\":\"6\"}]"
        )
        private Set<QuizDto> questions = new HashSet<>();

        @Schema(
                description = "Answer key containing correct answers for the question paper",
                implementation = AnswerKeyDto.class
        )
        private AnswerKeyDto answerKeyDto;

}
