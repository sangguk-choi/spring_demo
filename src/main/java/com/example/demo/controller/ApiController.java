package com.example.demo.controller;

import com.example.demo.dto.TestData;
import com.example.demo.entity.TestEntity;
import com.example.demo.exception.ApiException;
import com.example.demo.exception.ApiExceptionEnum;
import com.example.demo.service.ChatService;
import com.example.demo.service.TestService;
import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final ChatService chatService;
    private final ChatgptService chatgptService;

    private final TestService testService;

    @ResponseBody
    @PostMapping( value = "askChatGPT" )
    @ApiOperation(value = "Chat GPT api Connection")
//    public ChatResponse test0(@RequestBody ChatRequest chatRequest) {
    public String test0(@RequestBody ChatRequest chatRequest) {
        System.out.println("test0 start");
        String request = chatRequest.getPrompt();
        String response = chatService.getChatResponse(request);
//        ChatResponse response = chatService.getChatResponse2(chatRequest);
        System.out.println("test0 end");
        return response;
    }

    @GetMapping( value = "read_all_test")
    @ApiOperation(value = "Read All Test : CRUD")
    public ResponseEntity<List<TestEntity>> read_all_test() {

        List<TestEntity> testEnties = testService.read_all();

        return ResponseEntity.ok(testEnties);
    }

    @GetMapping( value = "read_test")
    @ApiOperation(value = "Read Test : CRUD")
    public ResponseEntity<TestEntity> read_test(@RequestParam("name") String name, @RequestParam("age") String age) {

        TestEntity testEntity = testService.read(name, age);

        return ResponseEntity.ok(testEntity);
    }

    @PostMapping( value = "create_test")
    @ApiOperation(value = "Create Test : CRUD")
    public ResponseEntity<TestEntity> create_test(@RequestBody TestData testData) {

        TestEntity testEntity = testService.create(testData);

        return ResponseEntity.ok(testEntity);
    }

    @PutMapping(value = "update_test/{id}")
    @ApiOperation(value = "Update Test : CRUD")
    public ResponseEntity<TestEntity> update_test(@PathVariable Integer id, @RequestBody TestData testData) {
        System.out.println("test0 start");
        TestEntity testEntity = testService.update(id, testData);

        return ResponseEntity.ok(testEntity);
    }

    @DeleteMapping( value = "delete_test/{id}")
    @ApiOperation(value = "Delete Test : CRUD")
    public ResponseEntity<Optional<TestEntity>> delete_test(@PathVariable Integer id) {

        Optional<TestEntity> testEntity = testService.delete(id);

        return ResponseEntity.ok(testEntity);
    }
}