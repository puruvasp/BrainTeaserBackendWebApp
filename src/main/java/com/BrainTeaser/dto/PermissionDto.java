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
@Schema(description = "Permission Details")
public class PermissionDto {

    @Schema(description = "Unique identifier of the permission", example = "201")
    private Long permissionId;

    @Schema(description = "Name of the permission", example = "READ_USER")
    private String permissionName;

    @Schema(description = "Detailed description of the permission", example = "Allows reading user information")
    private String description;

}
