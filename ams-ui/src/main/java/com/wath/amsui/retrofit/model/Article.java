package com.wath.amsui.retrofit.model;

public class Article {
    private String articleID;
    private String title;
    private String description;
    private Category category;
    private String thumbnail;

    public Article() {
    }

    public Article(String articleID, String title, String description, Category category, String thumbnail) {
        this.articleID = articleID;
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnail = thumbnail;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleID='" + articleID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
