package com.wath.amsui.service;

import com.wath.amsui.configuration.ApiGenerator;
import com.wath.amsui.retrofit.api.CategoryApi;
import com.wath.amsui.retrofit.model.ApiResponse;
import com.wath.amsui.retrofit.model.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CategoryService {

    @Value("${auth.user}")
    private String user;

    @Value("${auth.password}")
    private String password;


    public CompletableFuture<ApiResponse<Category>> getCategoryByID(int id){
        CompletableFuture<ApiResponse<Category>> cat = new CompletableFuture<>();
        CategoryApi categoryApi = ApiGenerator.createApi(CategoryApi.class,user,password);
        categoryApi.getCategory(id).enqueue(new Callback<ApiResponse<Category>>() {
            @Override
            public void onResponse(Call<ApiResponse<Category>> call, Response<ApiResponse<Category>> response) {
                cat.complete(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse<Category>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return cat;
    }

    public ApiResponse<List<Category>> getCategories(){
        CategoryApi categoryApi = ApiGenerator.createApi(CategoryApi.class,user,password);

        ApiResponse<List<Category>> categories = new ApiResponse<>();
        try{
            Response<ApiResponse<List<Category>>> response = categoryApi.getCategories().execute();
            categories = response.body();
        }catch (IOException e){
            System.out.println(e.toString());
        }
        return categories;
    }

}
