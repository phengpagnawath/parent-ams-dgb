package com.wath.asmapi.rest.response;

import com.wath.asmapi.repository.dto.CategoryDto;

public class ArticleResponse {
    private String articleID;
    private String title;
    private String description;
    private CategoryDto category;
    private String thumbnail;

    public ArticleResponse() {
    }

    public ArticleResponse(String articleID, String title, String description, CategoryDto category, String thumbnail) {
        this.articleID = articleID;
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "ArticleResponse{" +
                "articleID='" + articleID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", categoryDto=" + category +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
