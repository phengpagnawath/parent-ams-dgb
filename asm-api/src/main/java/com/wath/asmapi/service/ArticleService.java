package com.wath.asmapi.service;

import com.wath.asmapi.repository.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);
    List<ArticleDto> getRecentArticle(int limit);
    List<ArticleDto> getArticleInPopularCategory();

    ArticleDto getTopArticle();
}
