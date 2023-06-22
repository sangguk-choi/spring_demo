package com.example.demo.controller;

import com.example.demo.TestEntity;
import io.swagger.annotations.ApiOperation;
import jdk.jfr.ContentType;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping( value = "test1")
    @ApiOperation(value = "Test Sample1")
    public Object test1(@RequestParam("name") String name, @RequestParam("age") String age) {
        System.out.println("test");
        TestEntity testEntity = new TestEntity();

        testEntity.setName(name);
        testEntity.setAge(age);

        return ResponseEntity.ok(testEntity);
    }

    @GetMapping( value = "test2", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Test Sample2")
    public Object test2(@RequestParam String param) {
        return ResponseEntity.ok(param);
    }
}