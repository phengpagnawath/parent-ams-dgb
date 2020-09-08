package com.wath.asmapi.rest.message;

public enum SuccessMessage {
    
    FOUND_ALL("Found All "),
    FOUND_YOUR("Found Your "),
    IS_SAVED(" has been saved ");

    private String message;

    SuccessMessage(String message){
        this.message = message;
    }

    public String value(){
        return message;
    }
}