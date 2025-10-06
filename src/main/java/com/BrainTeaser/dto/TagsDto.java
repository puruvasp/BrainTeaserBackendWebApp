package com.BrainTeaser.dto;

import com.BrainTeaser.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Tags of the Question")
public class TagsDto{

    @Schema(description = "ID of the tag", required = true)
    private Long tagId;

    @Schema(description = "Name of the tag", required = true)
    private String tagName;

}

