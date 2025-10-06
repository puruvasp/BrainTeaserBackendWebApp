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
@Schema(description = "Category of the Question")
public class CategoryDto {

    @Schema(description = "Category id")
    private Long categoryId;

    @Schema(description = "Category name")
    private String categoryName;

}
