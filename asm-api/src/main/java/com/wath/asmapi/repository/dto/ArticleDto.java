package com.wath.asmapi.repository.dto;

import java.sql.Date;

public class ArticleDto {
    private int id;
    private String articleID;
    private String title;
    private String description;
    private String thumbnail;
    private String author;
    private CategoryDto category;
    private Date date;
    private boolean status;


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", articleID='" + getArticleID() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", author='" + getAuthor() + "'" +
            ", category='" + getCategory() + "'" +
            ", date='" + getDate() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }

    public ArticleDto() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleID() {
        return this.articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CategoryDto getCategory() {
        return this.category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    public ArticleDto(int id, String articleID, String title, String description, String thumbnail, String author, CategoryDto category, Date date, boolean status) {
        this.id = id;
        this.articleID = articleID;
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.author = author;
        this.category = category;
        this.date = date;
        this.status = status;
    }

}