package com.BrainTeaser.controller;

import com.BrainTeaser.dto.CategoryDto;
import com.BrainTeaser.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Category Controller", description = "Endpoints for managing question categories")
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("/create")
    @Operation(summary = "Create a new category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto created = categoryService.createCategory(categoryDto);
        return ResponseEntity.ok(created);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get category by ID")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        CategoryDto category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }


    @GetMapping("/{categoryName}")
    @Operation(summary = "Get category by name")
    public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable String categoryName) {
        CategoryDto category = categoryService.getCategoryByName(categoryName);
        return ResponseEntity.ok(category);
    }


    @GetMapping("/all")
    @Operation(summary = "Get all categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update category by ID")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        CategoryDto updated = categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{categoryName}")
    @Operation(summary = "Update category by name")
    public ResponseEntity<CategoryDto> updateCategoryByName(@PathVariable String categoryName, @RequestBody CategoryDto categoryDto) {
        CategoryDto updated = categoryService.updateCategoryByName(categoryName, categoryDto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete category by ID")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully with ID: " + id);
    }


    @DeleteMapping("/{categoryName}")
    @Operation(summary = "Delete category by name")
    public ResponseEntity<String> deleteCategoryByName(@PathVariable String categoryName) {
        categoryService.deleteCategoryByName(categoryName);
        return ResponseEntity.ok("Category deleted successfully with name: " + categoryName);
    }
}
