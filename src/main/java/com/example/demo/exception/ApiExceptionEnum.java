package com.example.demo.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ApiExceptionEnum {

    public static final ApiExceptionEnum TEST_EXCEPTION =
            new ApiExceptionEnum(HttpStatus.BAD_REQUEST, "E001", "테스트 Exception");

    public static final ApiExceptionEnum SECURITY_EXCEPTION =
            new ApiExceptionEnum(HttpStatus.UNAUTHORIZED, "S001", "로그인이 필요합니다.");

    private final HttpStatus status;
    private final String code;
    private String message;

    ApiExceptionEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ApiExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
