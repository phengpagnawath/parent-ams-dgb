package com.wath.amsui.retrofit.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ApiResponse<T> implements Serializable {
    private String message;
    private int code;
    private T data;
    private Timestamp timestamp;
    private boolean success;
    public ApiResponse() {
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public ApiResponse(String message, int code, T data, Timestamp timestamp, boolean success) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.timestamp = timestamp;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", timestamp=" + timestamp +
                ", success=" + success +
                '}';
    }
}
