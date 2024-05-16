package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @GetMapping( value = "test")
    @ApiOperation(value = "Test")
    public ResponseEntity<String> test() {

        String test = "test";

        return ResponseEntity.ok(test);
    }
}
