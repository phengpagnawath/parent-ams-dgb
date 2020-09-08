package com.wath.asmapi.repository;

import com.wath.asmapi.repository.dto.ArticleDto;
import com.wath.asmapi.repository.dto.CategoryDto;
import com.wath.asmapi.repository.provider.ArticleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {


    @Select("Select * From articles Where status = true")
    @Results(
            id = "articleResult",value = {
            @Result(property = "id" , column = "id"),
            @Result(property = "articleID" , column = "article_id"),
            @Result(property = "category",column = "category_id",
                    one = @One(select = "selectCategoryById"))
    })
    List<ArticleDto> getAll();


    @Select("Select id from categories where status = true and id = #{id} ")
    CategoryDto selectCategoryById(int id);

    @Select("Select * from articles where status = true and id = #{id}")
    ArticleDto find(int id);

    @InsertProvider(type = ArticleProvider.class,method = "saveSql")
    @Options(useGeneratedKeys =  true, keyColumn =  "id" , keyProperty = "id")
    void save(ArticleDto articleDto);

    @Select("Select * from articles where status = true order by create_date desc,id desc limit #{limit}")
    @ResultMap(value = "articleResult")
    List<ArticleDto> getRecentArticle(int limit);

    @Select("Select * from articles where status = true and category_id in (#{categoryID[0]}, #{categoryID[1]})")
    @ResultMap(value = "articleResult")
    List<ArticleDto> getArticleInPopularCategory(int[] categoryID);

    @Select("Select * from articles where status = true and category_id = #{categoryID} order by create_date desc,id desc limit 1")
    @ResultMap(value = "articleResult")
    ArticleDto getTopArticle(int categoryID);

    
}
