package com.BrainTeaser.controller;

import com.BrainTeaser.dto.ApplicationUserDto;
import com.BrainTeaser.service.ApplicationUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/application-user")
@Tag(name = "Application User", description = "CRUD operations for Application Users")
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService userService;

    @PostMapping("/create")
    @Operation(summary = "Create a new user")
    public ResponseEntity<ApplicationUserDto> createUser(@RequestBody ApplicationUserDto userDto) {
        ApplicationUserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID")
    public ResponseEntity<ApplicationUserDto> getUserById(@PathVariable Long id) {
        ApplicationUserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{username}")
    @Operation(summary = "Get a user by username")
    public ResponseEntity<ApplicationUserDto> getUserByUsername(@PathVariable String username) {
        ApplicationUserDto user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all users")
    public ResponseEntity<List<ApplicationUserDto>> getAllUsers() {
        List<ApplicationUserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{username}")
    @Operation(summary = "Update a user by username")
    public ResponseEntity<ApplicationUserDto> updateUser(
            @PathVariable String username,
            @RequestBody ApplicationUserDto userDto
    ) {
        ApplicationUserDto updatedUser = userService.updateUser(username, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user by ID")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{username}")
    @Operation(summary = "Delete a user by username")
    public ResponseEntity<Void> deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.noContent().build();
    }

}
