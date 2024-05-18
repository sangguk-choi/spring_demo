package com.example.demo.controller;

import com.example.demo.dto.TestDto;
import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestRepository;
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
    private final TestRepository testRepository;

    @GetMapping( value = "read")
    public ResponseEntity<TestDto> read_test(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {

        TestDto testDto = new TestDto();

        testDto = testService.findAllByNameAndAge(name, Integer.valueOf(age));

        return ResponseEntity.ok(testDto);
    }

    @PostMapping( value = "create")
//    public ResponseEntity<TestDto> create_test(@RequestParam(value="name") String name, @RequestParam(value="age") String age, @RequestParam(value="hometown") String hometown) {
    public ResponseEntity<TestDto> create_test(@RequestBody TestDto testDto) {

       TestDto testDto_out = new TestDto();

        testDto_out = testService.save(testDto);

       return ResponseEntity.ok(testDto_out);
    }

    @PutMapping( value = "update")
    public ResponseEntity<TestDto> update_test(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {

        TestDto testDto = new TestDto();

        testDto = testService.findAllByNameAndAge(name, Integer.valueOf(age));

        return ResponseEntity.ok(testDto);
    }

    @DeleteMapping( value = "delete")
    public ResponseEntity<String> delete_test(@RequestParam String id) {

        String retValue;

        retValue = testService.deleteById(Integer.valueOf(id));

        return ResponseEntity.ok(retValue);
    }

}