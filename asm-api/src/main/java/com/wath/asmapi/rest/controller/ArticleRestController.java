package com.wath.asmapi.rest.controller;


import com.wath.asmapi.constant.ApiConstant;
import com.wath.asmapi.repository.dto.ArticleDto;
import com.wath.asmapi.rest.response.ApiResponse;
import com.wath.asmapi.rest.response.ArticleResponse;
import com.wath.asmapi.rest.response.CategoryResponse;
import com.wath.asmapi.service.ArticleService;
import com.wath.asmapi.service.imp.ArticleServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_VERSION)
public class ArticleRestController {

    private ArticleServiceImp articleServiceImp;

    @Autowired
    public ArticleRestController(ArticleServiceImp articleServiceImp) {
        this.articleServiceImp = articleServiceImp;
    }

    @GetMapping(ApiConstant.ARTICLE_URL)
    ResponseEntity<ApiResponse<List<ArticleResponse>>> getRecentArticle(@RequestParam int limit){
        ApiResponse<List<ArticleResponse>> response = new ApiResponse<>();
        ModelMapper mapper = new ModelMapper();
        List<ArticleResponse> articleResponseList = new ArrayList<>();
        List<ArticleDto> articleRecentList = articleServiceImp.getRecentArticle(limit);

        for(ArticleDto articleDto:articleRecentList){
            articleResponseList.add(mapper.map(articleDto,ArticleResponse.class));
        }

        response.setCode(HttpStatus.OK.value());
        response.setMessage("Your category API done");
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        response.setData(articleResponseList);

        return ResponseEntity.ok(response);
    }

    @GetMapping(ApiConstant.ARTICLE_URL+"/popular")
    ResponseEntity<ApiResponse<List<ArticleResponse>>> getPopularCategory(){
        ApiResponse<List<ArticleResponse>> response = new ApiResponse<>();
        ModelMapper mapper = new ModelMapper();
        List<ArticleResponse> articleResponseList = new ArrayList<>();
        List<ArticleDto> articlePopularList = articleServiceImp.getArticleInPopularCategory();

        for(ArticleDto article:articlePopularList){
            articleResponseList.add(mapper.map(article,ArticleResponse.class));
        }
        response.setCode(HttpStatus.OK.value());
        response.setMessage("Your category API done");
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        response.setData(articleResponseList);

        return ResponseEntity.ok(response);
    }

    @GetMapping(ApiConstant.ARTICLE_URL+"/top")
    ResponseEntity<ApiResponse<ArticleResponse>> getTopArticle(){
        ApiResponse<ArticleResponse> response = new ApiResponse<>();
        ModelMapper mapper = new ModelMapper();
        ArticleResponse articleResponse = new ArticleResponse();
        ArticleDto topArticle= articleServiceImp.getTopArticle();
        articleResponse = mapper.map(topArticle,ArticleResponse.class);
        response.setCode(HttpStatus.OK.value());
        response.setMessage("Your category API done");
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        response.setData(articleResponse);

        return ResponseEntity.ok(response);
    }
}