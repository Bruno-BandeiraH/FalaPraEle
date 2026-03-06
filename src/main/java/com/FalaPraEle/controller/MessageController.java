package com.FalaPraEle.controller;

import com.FalaPraEle.domain.entity.Message;
import com.FalaPraEle.dto.message.ChatMessageDTO;
import com.FalaPraEle.dto.message.MessageCreationDTO;
import com.FalaPraEle.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MessageCreationDTO data, UriComponentsBuilder uriBuilder) {
        Message message = messageService.create(data);
        var uri =  uriBuilder.path("/message/{id}").buildAndExpand(message.getId()).toUri();
        return ResponseEntity.created(uri).body(message);
    }

    @GetMapping("/{chatId}")
    public ResponseEntity listMessagesByChatId(@PathVariable String chatId) {
        List<ChatMessageDTO> chats = messageService.listMessagesByChatId(chatId);
        return ResponseEntity.ok(chats);
    }
}
