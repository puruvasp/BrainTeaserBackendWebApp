package com.BrainTeaser.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Difficulty level")
public class DifficultyDto {

    @Schema(description = "Difficulty id")
    private Long difficultyId;

    @Schema(description = "Difficulty name")
    private String difficultyName;

}
