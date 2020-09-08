package com.wath.asmapi.rest.controller;

import com.wath.asmapi.constant.ApiConstant;
import com.wath.asmapi.repository.dto.CategoryDto;
import com.wath.asmapi.rest.message.FailMessage;
import com.wath.asmapi.rest.message.SuccessMessage;
import com.wath.asmapi.rest.request.CategoryRequest;
import com.wath.asmapi.rest.response.ApiResponse;
import com.wath.asmapi.rest.response.CategoryResponse;
import com.wath.asmapi.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_VERSION)
public class CategoryRestController {
    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(ApiConstant.CATEGORY_URL)
    ResponseEntity<ApiResponse<List<CategoryResponse>>> getCategoriesAPI(){
        
        ApiResponse<List<CategoryResponse>> response = new ApiResponse<>();
        ModelMapper mapper = new ModelMapper();

        List<CategoryDto> categoryDtoList = categoryService.categoriesSelect();

        List<CategoryResponse> categoryResponseList = new ArrayList<>();

        for(CategoryDto categoryDto : categoryDtoList){
            categoryResponseList.add(mapper.map(categoryDto,CategoryResponse.class));
        }

        response.setCode(HttpStatus.OK.value());
        response.setMessage("Your category API done");
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        response.setData(categoryResponseList);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/related-categories")
    ResponseEntity<ApiResponse<List<CategoryResponse>>> getCategoryRandom(@RequestParam int limit){
        ApiResponse<List<CategoryResponse>> response = new ApiResponse<>();

        ModelMapper mapper = new ModelMapper();

        List<CategoryDto> categoryRandom = categoryService.randomCategory(limit);

        List<CategoryResponse> categoryResponses = new ArrayList<>();
        if(categoryRandom!=null) {
            for (CategoryDto category:categoryRandom){
                categoryResponses.add(mapper.map(category,CategoryResponse.class));
            }
            response.setMessage(SuccessMessage.FOUND_YOUR.value()+"Category");
            response.setSuccess(true);
            response.setCode(HttpStatus.OK.value());
            response.setData(categoryResponses);
        }
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get a Category by its id")
    @GetMapping(ApiConstant.CATEGORY_URL+"/{id}")
    ResponseEntity<ApiResponse<CategoryResponse>> getCategoryByIDAPI(@PathVariable int id){
        
        ApiResponse<CategoryResponse> response = new ApiResponse<>();

        ModelMapper mapper = new ModelMapper();

        CategoryDto categoryDto = categoryService.finCategory(id);
        
        if(categoryDto!=null){
            CategoryResponse categoryResponse = mapper.map(categoryDto,CategoryResponse.class);
            response.setMessage(SuccessMessage.FOUND_YOUR.value()+"Category");
            response.setSuccess(true);
            response.setCode(HttpStatus.OK.value());
            response.setData(categoryResponse);
        }else{
            response.setMessage(FailMessage.NOT_FOUND_YOUR.value()+"Category");
            response.setSuccess(false);
            response.setCode(HttpStatus.NOT_FOUND.value());
            response.setData(null);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping(ApiConstant.CATEGORY_URL)
    ResponseEntity<ApiResponse<CategoryResponse>> addCategory(@RequestBody CategoryRequest categoryRequest){

        ApiResponse<CategoryResponse> response = new ApiResponse<>();

        ModelMapper mapper = new ModelMapper();

        CategoryDto categoryDto = mapper.map(categoryRequest, CategoryDto.class);
        CategoryDto categorySave = categoryService.create(categoryDto);
        CategoryResponse categoryResponse = mapper.map(categorySave, CategoryResponse.class);

        response.setMessage("Category"+SuccessMessage.IS_SAVED.value());
        response.setSuccess(true);
        response.setCode(HttpStatus.OK.value());
        response.setData(categoryResponse);

        return ResponseEntity.ok(response);
    }

    @PutMapping(ApiConstant.CATEGORY_URL+"/{id}")
    ResponseEntity<ApiResponse<CategoryResponse>> update(@PathVariable int id, @RequestBody CategoryRequest categoryRequest){
        ApiResponse<CategoryResponse> response = new ApiResponse<>();

        ModelMapper mapper = new ModelMapper();

        CategoryDto categoryDto = categoryService.finCategory(id);

        if(categoryDto!=null){
            categoryDto = mapper.map(categoryRequest,CategoryDto.class);
            categoryDto.setId(id);
            CategoryResponse categoryResponse = mapper.map(categoryService.update(categoryDto), CategoryResponse.class);
            response.setMessage(SuccessMessage.FOUND_YOUR.value()+"Category");
            response.setSuccess(true);
            response.setCode(HttpStatus.OK.value());
            response.setData(categoryResponse);
        }else{
            response.setMessage(FailMessage.NOT_FOUND_YOUR.value()+"Category");
            response.setSuccess(false);
            response.setCode(HttpStatus.NOT_FOUND.value());
            response.setData(null);
        }
        return ResponseEntity.ok(response);
    }


}
