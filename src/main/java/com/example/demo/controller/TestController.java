package com.example.demo.controller;

import com.example.demo.dto.TestDto;
import com.example.demo.service.TestService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping( value = "test")
    public ResponseEntity<TestDto> findAllByNameAndAge(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {

        TestDto testDto = new TestDto();

        testDto = testService.findAllByNameAndAge(name, Integer.valueOf(age));

        return ResponseEntity.ok(testDto);
    }

}