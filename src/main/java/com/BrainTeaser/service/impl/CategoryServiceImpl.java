package com.BrainTeaser.service.impl;

import com.BrainTeaser.dto.CategoryDto;
import com.BrainTeaser.model.Category;
import com.BrainTeaser.repository.CategoryRepository;
import com.BrainTeaser.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private CategoryDto mapToDto(Category category) {
        return new CategoryDto(
                category.getCategoryId(),
                category.getCategoryName()
        );
    }

    private Category mapToEntity(CategoryDto dto) {
        Category category = new Category();
        category.setCategoryId(dto.getCategoryId());
        category.setCategoryName(dto.getCategoryName());
        return category;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = mapToEntity(categoryDto);
        Category saved = categoryRepository.save(category);
        return mapToDto(saved);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        return mapToDto(category);
    }

    @Override
    public CategoryDto getCategoryByName(String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(() -> new RuntimeException("Category not found with name " + categoryName));
        return mapToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        existing.setCategoryName(categoryDto.getCategoryName());
        Category updated = categoryRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public CategoryDto updateCategoryByName(String categoryName, CategoryDto categoryDto) {
        Category existing = categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(() -> new RuntimeException("Category not found with name " + categoryName));

        existing.setCategoryName(categoryDto.getCategoryName());
        Category updated = categoryRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        categoryRepository.delete(category);
    }

    @Override
    public void deleteCategoryByName(String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(() -> new RuntimeException("Category not found with name " + categoryName));
        categoryRepository.delete(category);
    }
}
