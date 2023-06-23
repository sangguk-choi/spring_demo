package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class ApiExceptionEntity {
    private final HttpStatus status;
    private final String code;
    private final String message;

    @Builder
    public ApiExceptionEntity(ApiExceptionEnum exceptionEnum){
        this.status = exceptionEnum.getStatus();
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }
}
