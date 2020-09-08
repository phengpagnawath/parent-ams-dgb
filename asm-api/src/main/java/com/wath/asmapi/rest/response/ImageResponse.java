package com.wath.asmapi.rest.response;

public class ImageResponse {
    
    private String name;
    private String uri;
    private String fileType;
    private long fileSize;

    public ImageResponse() {
    
    }

    public ImageResponse(String name, String uri, String fileType, long fileSize) {
        this.name = name;
        this.uri = uri;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", uri='" + getUri() + "'" +
            ", fileType='" + getFileType() + "'" +
            ", fileSize='" + getFileSize() + "'" +
            "}";
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

}