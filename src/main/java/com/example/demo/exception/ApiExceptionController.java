package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ApiExceptionController {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiExceptionEntity> ApiExceptionHandler(ApiException e) {
        System.out.println("Exception 발생");
        ApiExceptionEntity apiExceptionEntity = new ApiExceptionEntity(e.getError());
        return ResponseEntity
                .status(apiExceptionEntity.getStatus())
                .body(apiExceptionEntity);
    }
}
