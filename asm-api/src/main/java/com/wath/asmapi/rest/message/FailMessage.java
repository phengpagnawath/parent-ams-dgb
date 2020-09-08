package com.wath.asmapi.rest.message;

public enum FailMessage {
    NOT_FOUND(" Empty "),
    NOT_FOUND_YOUR("Could Not Found Your ");

    private String message;

    FailMessage(String message){
        this.message = message;
    }

    public String value(){
        return message;

    }
    
}