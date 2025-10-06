package com.BrainTeaser.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Topic and Information")
public class TopicDto {

    @Schema(description = "ID of the topic", required = true)
    private Long topicId;

    @Schema(description = "Name of the topic", required = true)
    private String topicName;
}
