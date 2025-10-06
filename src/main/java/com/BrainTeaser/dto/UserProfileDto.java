package com.BrainTeaser.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "User Profile Details")
public class UserProfileDto {

    @Schema(description = "Unique identifier of the user profile", example = "UP123456")
    private String userProfileId;

    @Schema(description = "First name of the user", example = "John")
    private String firstName;

    @Schema(description = "Last name of the user", example = "Doe")
    private String lastName;

    @Schema(description = "Phone number of the user", example = "+1-202-555-0147")
    private String phoneNumber;

}
