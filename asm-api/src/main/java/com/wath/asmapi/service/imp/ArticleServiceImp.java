package com.wath.asmapi.service.imp;

import com.wath.asmapi.repository.ArticleRepository;
import com.wath.asmapi.repository.CategoryRepository;
import com.wath.asmapi.repository.dto.ArticleDto;
import com.wath.asmapi.repository.dto.CategoryDto;
import com.wath.asmapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {

    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public ArticleServiceImp(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        try{
            articleRepository.save(articleDto);
            return articleDto;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<ArticleDto> getRecentArticle(int limit) {
        return articleRepository.getRecentArticle(limit);
    }

    @Override
    public List<ArticleDto> getArticleInPopularCategory() {
        List<CategoryDto> popularCategory = categoryRepository.getPopularCategory(2);
        int[] categoryID = new int[popularCategory.size()];
        int i=0;
        for (CategoryDto categoryDto:popularCategory){
            categoryID[i] = categoryDto.getId();
            i++;
        }
        return articleRepository.getArticleInPopularCategory(categoryID);
    }

    @Override
    public ArticleDto getTopArticle() {
        int i = 1;
        List<CategoryDto> topCategory = categoryRepository.getPopularCategory(i);
        int categoryID = topCategory.get(0).getId();
        return articleRepository.getTopArticle(categoryID);
    }
}
