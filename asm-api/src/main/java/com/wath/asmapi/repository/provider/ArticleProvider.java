package com.wath.asmapi.repository.provider;

import org.apache.ibatis.jdbc.SQL;

import javax.validation.Valid;

public class ArticleProvider {

    public String saveSql(){
        return new SQL(){{
            INSERT_INTO("articles");
            VALUES("article_id","#{articleID}");
            VALUES("title","#{title}");
            VALUES("description","#{description}");
            VALUES("thumbnail","#{thumbnail}");
            VALUES("author","#{author}");
            VALUES("category_id","#{category.id}");
        }}.toString();
    }
}
