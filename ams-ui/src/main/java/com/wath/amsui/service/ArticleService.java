package com.wath.amsui.service;

import com.wath.amsui.configuration.ApiGenerator;
import com.wath.amsui.retrofit.api.ArticleApi;
import com.wath.amsui.retrofit.model.ApiResponse;
import com.wath.amsui.retrofit.model.Article;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class ArticleService {

    @Value("${auth.user}")
    private String user;

    @Value("${auth.password}")
    private String password;

    public ApiResponse<List<Article>> getRecentArticle(){
        ArticleApi articleApi = ApiGenerator.createApi(ArticleApi.class,user,password);

        ApiResponse<List<Article>> articles = new ApiResponse<>();

        try{
            Response<ApiResponse<List<Article>>> response = articleApi.getRecentArticle(3).execute();
            articles = response.body();
        }catch (IOException e){
            e.printStackTrace();
        }
        return articles;
    }

    public ApiResponse<List<Article>> getPopularArticle(){
        ArticleApi articleApi = ApiGenerator.createApi(ArticleApi.class,user,password);
        ApiResponse<List<Article>> articles = new ApiResponse<>();

        try{
            Response<ApiResponse<List<Article>>> response = articleApi.getPopularArticle().execute();
            articles = response.body();
        }catch (IOException e){
            e.printStackTrace();
        }
        return articles;
    }

}
