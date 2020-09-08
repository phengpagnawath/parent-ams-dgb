package com.wath.amsui.retrofit.api;

import com.wath.amsui.retrofit.model.ApiResponse;
import com.wath.amsui.retrofit.model.Article;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ArticleApi {

    @GET("articles")
    Call<ApiResponse<List<Article>>> getRecentArticle(@Query("limit") int limit);

    @GET("articles/popular")
    Call<ApiResponse<List<Article>>> getPopularArticle();

}
