package com.example.demo.controller;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    @GetMapping( value = "test")
    @ApiOperation(value = "Test")
    public ResponseEntity<String> test() {

        String test = "test";

        return ResponseEntity.ok(test);
    }
}