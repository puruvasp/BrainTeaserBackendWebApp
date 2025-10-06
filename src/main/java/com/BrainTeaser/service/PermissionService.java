package com.BrainTeaser.service;

import com.BrainTeaser.dto.PermissionDto;
import java.util.List;

public interface PermissionService {

    PermissionDto createPermission(PermissionDto permissionDto);

    PermissionDto getPermissionById(Long id);

    PermissionDto getPermissionByName(String permissionName);

    List<PermissionDto> getAllPermissions();

    PermissionDto updatePermission(Long id, PermissionDto permissionDto);

    PermissionDto updatePermissionByName(String permissionName, PermissionDto permissionDto);

    void deletePermission(Long id);

    void deletePermissionByName(String permissionName);
}
