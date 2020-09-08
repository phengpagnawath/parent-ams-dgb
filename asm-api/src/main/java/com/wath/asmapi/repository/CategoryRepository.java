package com.wath.asmapi.repository;

import com.wath.asmapi.repository.dto.CategoryDto;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository {

    @Select("Select * From categories Where status = true")
    List<CategoryDto> findAll();

    @Select("Select * from categories where status = true and id = #{id}")
    CategoryDto findOne(int id);

    @Insert("insert into categories(name) values(#{name}) ")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void createCategory(CategoryDto categoryDto);

    @Update("Update categories set name = #{name} where id = #{id}")
    void updateCategory(CategoryDto newCategoryDto);

    @Update("update categories set status = false where id = #{id}")
    boolean delete(int id);

    @Select("Select id,name,COALESCE(null,num_article,0) as articles_count from categories left join (select\n" +
            "category_id,count(article_id) num_article from articles where status = true group by category_id)count_article\n" +
            "on count_article.category_id= categories.id order by articles_count desc limit #{limit}")
    List<CategoryDto> getPopularCategory(int limit);

    @Select("Select * from categories where status = true order by random() limit #{limit}")
    List<CategoryDto> getRandomCategory(int limit);
    
}
