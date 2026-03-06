package com.FalaPraEle.controller;

import com.FalaPraEle.domain.entity.Chat;
import com.FalaPraEle.dto.chat.ChatCreationDTO;
import com.FalaPraEle.dto.chat.ChatInformationDTO;
import com.FalaPraEle.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ChatCreationDTO data, UriComponentsBuilder uriBuilder) {
        Chat chat = chatService.create(data);
        var uri =  uriBuilder.path("/chats/{id}").buildAndExpand(chat.getId()).toUri();
        return ResponseEntity.created(uri).body(chat);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        ChatInformationDTO chat = chatService.findById(id);
        return ResponseEntity.ok(chat);
    }
}
