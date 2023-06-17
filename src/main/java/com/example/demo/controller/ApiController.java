package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping( value = "test1", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Test Sample1")
    public Object sample1(@RequestParam String param) {
        return ResponseEntity.ok(param);
    }

    @GetMapping( value = "test2", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Test Sample2")
    public Object sample2(@RequestParam String param) {
        return ResponseEntity.ok(param);
    }
}