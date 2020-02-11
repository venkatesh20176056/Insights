package com.paytm.daas.springmongo.enums;

import org.springframework.http.HttpStatus;

public enum ErrorMessages {
    
    INVALID_SEVERITY(1, HttpStatus.BAD_REQUEST, "No data found for given severity." );
    
    int code;
    HttpStatus httpStatus;
    String message;
    
    private ErrorMessages(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
