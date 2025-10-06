package com.BrainTeaser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Application User Details")
public class ApplicationUserDto {

    @Schema(description = "Unique identifier of the application user", example = "101")
    private Long applicationUserId;

    @Schema(description = "Username of the application user", example = "john_doe")
    private String username;

    @Schema(description = "Email address of the application user", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Password of the application user", example = "P@ssw0rd123")
    private String password;

    @Schema(description = "Account status (e.g., ACTIVE, INACTIVE, BLOCKED)", example = "ACTIVE")
    private String status;

    @Schema(description = "Timestamp of the last login", example = "2025-10-03T14:30:00")
    private LocalDateTime lastLogin;

    @Schema(description = "IP address of the last login", example = "192.168.1.10")
    private String lastLoginIP;

}
