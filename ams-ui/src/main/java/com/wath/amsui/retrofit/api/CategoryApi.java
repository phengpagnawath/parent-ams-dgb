package com.wath.amsui.retrofit.api;

import com.wath.amsui.retrofit.model.ApiResponse;
import com.wath.amsui.retrofit.model.Category;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface CategoryApi {

    @GET("categories")
    Call<ApiResponse<List<Category>>> getCategories();

    @GET("categories/{id}")
    Call<ApiResponse<Category>> getCategory(@Path("id") int id);
}
