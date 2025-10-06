package com.BrainTeaser.service;

import com.BrainTeaser.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long id);

    CategoryDto getCategoryByName(String categoryName);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long id, CategoryDto categoryDto);

    CategoryDto updateCategoryByName(String categoryName, CategoryDto categoryDto);

    void deleteCategory(Long id);

    void deleteCategoryByName(String categoryName);
}
