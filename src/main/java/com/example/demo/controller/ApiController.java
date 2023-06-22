package com.example.demo.controller;

import com.example.demo.entity.ChatReqEntity;
import com.example.demo.entity.TestEntity;
import com.example.demo.service.ChatService;
import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ApiController {
    private final ChatService chatService;
    private final ChatgptService chatgptService;

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