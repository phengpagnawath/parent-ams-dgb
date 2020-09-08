package com.wath.asmapi.service.imp;

import com.wath.asmapi.repository.CategoryRepository;
import com.wath.asmapi.repository.dto.CategoryDto;
import com.wath.asmapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> categoriesSelect() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDto finCategory(int id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public CategoryDto update(CategoryDto newCategoryDto) {
        if(newCategoryDto.getName().equals(null)){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try{
            System.out.println(newCategoryDto);
            categoryRepository.updateCategory(newCategoryDto);
            return newCategoryDto;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getCause().getMessage());
        }
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        if(categoryDto.getName().equals(null)){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try{
            categoryRepository.createCategory(categoryDto);
            return categoryDto;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getCause().getMessage());
        }
        
    }

    @Override
    public List<CategoryDto> randomCategory(int limit) {
        return categoryRepository.getRandomCategory(limit);
    }
}
