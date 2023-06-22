package com.example.demo.service;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatgptService chatgptService;

    public String getChatResponse(String prompt) {
        System.out.println("ChatService Start");
        String response = chatgptService.sendMessage(prompt);
        System.out.println("ChatService End");
        return response;
    }

    public ChatResponse getChatResponse2(ChatRequest prompt) {
        System.out.println("ChatService2 Start");
        ChatResponse response = chatgptService.sendChatRequest(prompt);
        System.out.println("ChatService2 End");
        return response;
    }
}
