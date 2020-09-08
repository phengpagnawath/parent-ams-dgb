package com.wath.asmapi.rest.request;

public class CategoryRequest {
    
    private String name;

    public CategoryRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "name='" + name + '\'' +
                '}';
    }
}