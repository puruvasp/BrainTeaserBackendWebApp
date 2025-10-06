package com.BrainTeaser.util;

import com.BrainTeaser.dto.PermissionDto;
import com.BrainTeaser.model.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionUtility {

    public abstract Permission toPermissionEntity(PermissionDto permissionDto);
    public abstract PermissionDto toPermissionDto(Permission permission);

}
