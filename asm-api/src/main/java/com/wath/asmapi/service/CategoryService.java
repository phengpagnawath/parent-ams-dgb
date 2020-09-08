package com.wath.asmapi.service;

import com.wath.asmapi.repository.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> categoriesSelect();
    CategoryDto finCategory(int id);
    CategoryDto create(CategoryDto categoryDto);
    CategoryDto update(CategoryDto newCategoryDto);

    List<CategoryDto> randomCategory(int limit);
    
}
