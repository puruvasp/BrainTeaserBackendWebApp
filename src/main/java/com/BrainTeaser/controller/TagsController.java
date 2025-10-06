package com.BrainTeaser.controller;

import com.BrainTeaser.dto.TagsDto;
import com.BrainTeaser.service.TagsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
@Tag(name = "Tags Controller", description = "Endpoints for managing question tags")
public class TagsController {

    private final TagsService tagsService;

    @Operation(summary = "Create a new tag")
    @PostMapping("/create")
    public ResponseEntity<TagsDto> createTag(@RequestBody TagsDto tagsDto) {
        TagsDto createdTag = tagsService.createTag(tagsDto);
        return ResponseEntity.ok(createdTag);
    }

    @Operation(summary = "Get tag by ID")
    @GetMapping("/{id}")
    public ResponseEntity<TagsDto> getTagById(@PathVariable Long id) {
        TagsDto tag = tagsService.getTagById(id);
        return ResponseEntity.ok(tag);
    }

    @Operation(summary = "Get tag by name")
    @GetMapping("/{tagName}")
    public ResponseEntity<TagsDto> getTagByName(@PathVariable String tagName) {
        TagsDto tag = tagsService.getTagByName(tagName);
        return ResponseEntity.ok(tag);
    }

    @Operation(summary = "Get all tags")
    @GetMapping("/all")
    public ResponseEntity<List<TagsDto>> getAllTags() {
        List<TagsDto> tags = tagsService.getAllTags();
        return ResponseEntity.ok(tags);
    }

    @Operation(summary = "Update tag by ID")
    @PutMapping("/{id}")
    public ResponseEntity<TagsDto> updateTag(@PathVariable Long id, @RequestBody TagsDto tagsDto) {
        TagsDto updatedTag = tagsService.updateTag(id, tagsDto);
        return ResponseEntity.ok(updatedTag);
    }

    @PutMapping("/{tagName}")
    public ResponseEntity<TagsDto> updateTagByName(@PathVariable String tagName, @RequestBody TagsDto tagsDto) {
        TagsDto updatedTag = tagsService.updateTagByName(tagName, tagsDto);
        return ResponseEntity.ok(updatedTag);
    }

    @Operation(summary = "Delete tag by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable Long id) {
        tagsService.deleteTag(id);
        return ResponseEntity.ok("Tag deleted successfully with ID: " + id);
    }

    @Operation(summary = "Delete tag by name")
    @DeleteMapping("/{tagName}")
    public ResponseEntity<String> deleteTagByName(@PathVariable String tagName) {
        tagsService.deleteTagByName(tagName);
        return ResponseEntity.ok("Tag deleted successfully with name: " + tagName);
    }
}
