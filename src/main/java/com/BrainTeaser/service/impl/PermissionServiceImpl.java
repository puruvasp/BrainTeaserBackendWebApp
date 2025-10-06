package com.BrainTeaser.service.impl;

import com.BrainTeaser.dto.PermissionDto;
import com.BrainTeaser.model.Permission;
import com.BrainTeaser.repository.PermissionRepository;
import com.BrainTeaser.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    private PermissionDto mapToDto(Permission permission) {
        return new PermissionDto(
                permission.getPermissionId(),
                permission.getPermissionName(),
                permission.getDescription()
        );
    }

    private Permission mapToEntity(PermissionDto dto) {
        Permission permission = new Permission();
        permission.setPermissionId(dto.getPermissionId());
        permission.setPermissionName(dto.getPermissionName());
        permission.setDescription(dto.getDescription());
        return permission;
    }

    @Override
    public PermissionDto createPermission(PermissionDto permissionDto) {
        Permission permission = mapToEntity(permissionDto);
        Permission saved = permissionRepository.save(permission);
        return mapToDto(saved);
    }

    @Override
    public PermissionDto getPermissionById(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with id " + id));
        return mapToDto(permission);
    }

    @Override
    public PermissionDto getPermissionByName(String permissionName) {
        Permission permission = permissionRepository.findByPermissionName(permissionName)
                .orElseThrow(() -> new RuntimeException("Permission not found with name " + permissionName));
        return mapToDto(permission);
    }

    @Override
    public List<PermissionDto> getAllPermissions() {
        return permissionRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PermissionDto updatePermission(Long id, PermissionDto permissionDto) {
        Permission existing = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with id " + id));

        existing.setPermissionName(permissionDto.getPermissionName());
        existing.setDescription(permissionDto.getDescription());

        Permission updated = permissionRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public PermissionDto updatePermissionByName(String permissionName, PermissionDto permissionDto) {
        Permission existing = permissionRepository.findByPermissionName(permissionName)
                .orElseThrow(() -> new RuntimeException("Permission not found with name " + permissionName));

        existing.setPermissionName(permissionDto.getPermissionName());
        existing.setDescription(permissionDto.getDescription());

        Permission updated = permissionRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deletePermission(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with id " + id));
        permissionRepository.delete(permission);
    }

    @Override
    public void deletePermissionByName(String permissionName) {
        Permission permission = permissionRepository.findByPermissionName(permissionName)
                .orElseThrow(() -> new RuntimeException("Permission not found with name " + permissionName));
        permissionRepository.delete(permission);
    }
}
