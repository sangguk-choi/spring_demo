package com.example.demo.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private ApiExceptionEnum error;

    public ApiException(ApiExceptionEnum e) {
        super(e.getMessage());
        this.error = e;
    }
}
