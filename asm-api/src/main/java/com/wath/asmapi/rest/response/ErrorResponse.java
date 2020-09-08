package com.wath.asmapi.rest.response;

import java.io.Serializable;
import java.sql.Timestamp;

public class ErrorResponse implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String message;
    private int code;
    private String error;
    private Timestamp timestamp;


    public ErrorResponse() {
    }
    

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", code='" + getCode() + "'" +
            ", detail='" + getDetail() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetail() {
        return this.error;
    }

    public void setDetail(String detail) {
        this.error = detail;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}