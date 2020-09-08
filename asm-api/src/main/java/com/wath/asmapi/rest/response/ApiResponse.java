package com.wath.asmapi.rest.response;

import java.io.Serializable;
import java.sql.Timestamp;

public class ApiResponse<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4072182866380492630L;
    private String message;
    private int code;
    private T data;
    private Timestamp timestamp;
    private boolean success;
    public ApiResponse() {
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
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

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
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
}
