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

    
}
