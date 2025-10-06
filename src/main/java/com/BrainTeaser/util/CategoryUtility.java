package com.BrainTeaser.util;

import com.BrainTeaser.dto.CategoryDto;
import com.BrainTeaser.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryUtility {

    public abstract Category toCategoryEntity(CategoryDto categoryDto);
    public abstract CategoryDto toCategoryDto(Category category);
}
