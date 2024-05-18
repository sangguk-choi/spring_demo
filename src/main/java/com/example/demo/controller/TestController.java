package com.example.demo.controller;

import com.example.demo.dto.TestRequest;
import com.example.demo.dto.TestResponse;
import com.example.demo.repository.TestRepository;
import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    private final TestRepository testRepository;

    @GetMapping( value = "read")
    public ResponseEntity<TestResponse> read_test(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {

        TestResponse testResponse = new TestResponse();

        testResponse = testService.readService(name, Integer.valueOf(age));

        return ResponseEntity.ok(testResponse);
    }

    @PostMapping( value = "create")
    public ResponseEntity<TestResponse> create_test(@RequestBody TestRequest testRequest) {

        TestResponse testResponse = new TestResponse();

        testResponse = testService.createService(testRequest);

       return ResponseEntity.ok(testResponse);
    }

    @PutMapping( value = "update/{id}")
    public ResponseEntity<TestResponse> update_test(@PathVariable Integer id, @RequestBody TestRequest testRequest) {

        TestResponse testResponse = new TestResponse();

        testResponse = testService.updateService(Integer.valueOf(id), testRequest);

        return ResponseEntity.ok(testResponse);
    }

    @DeleteMapping( value = "delete")
    public ResponseEntity<String> delete_test(@RequestParam String id) {

        String retValue;

        retValue = testService.deleteService(Integer.valueOf(id));

        return ResponseEntity.ok(retValue);
    }

}