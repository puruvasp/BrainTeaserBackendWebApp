package com.BrainTeaser.controller;

import com.BrainTeaser.dto.PermissionDto;
import com.BrainTeaser.service.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permission")
@Tag(name = "Permission", description = "Permission Management")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/create")
    @Operation(summary = "Create a new permission")
    public ResponseEntity<PermissionDto> createPermission(@RequestBody PermissionDto permissionDto) {
        PermissionDto created = permissionService.createPermission(permissionDto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a permission by ID")
    public ResponseEntity<PermissionDto> getPermissionById(@PathVariable Long id) {
        PermissionDto permission = permissionService.getPermissionById(id);
        return ResponseEntity.ok(permission);
    }

    @GetMapping("/{permissionName}")
    @Operation(summary = "Get a permission by name")
    public ResponseEntity<PermissionDto> getPermissionByName(@PathVariable String permissionName) {
        PermissionDto permission = permissionService.getPermissionByName(permissionName);
        return ResponseEntity.ok(permission);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all permissions")
    public ResponseEntity<List<PermissionDto>> getAllPermissions() {
        List<PermissionDto> permissions = permissionService.getAllPermissions();
        return ResponseEntity.ok(permissions);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a permission by ID")
    public ResponseEntity<PermissionDto> updatePermission(@PathVariable Long id, @RequestBody PermissionDto permissionDto) {
        PermissionDto updated = permissionService.updatePermission(id, permissionDto);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{permissionName}")
    @Operation(summary = "Update permission by name")
    public ResponseEntity<PermissionDto> updatePermissionByName(@PathVariable String permissionName, @RequestBody PermissionDto permissionDto) {
        PermissionDto updated = permissionService.updatePermissionByName(permissionName, permissionDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a permission by ID")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{permissionName}")
    @Operation(summary = "Delete a permission by name")
    public ResponseEntity<Void> deletePermissionByName(@PathVariable String permissionName) {
        permissionService.deletePermissionByName(permissionName);
        return ResponseEntity.noContent().build();
    }
}
