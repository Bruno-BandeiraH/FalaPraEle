package com.FalaPraEle.service;

import com.FalaPraEle.domain.entity.Chat;
import com.FalaPraEle.domain.entity.Message;
import com.FalaPraEle.domain.repository.MessageRepository;
import com.FalaPraEle.dto.message.ChatMessageDTO;
import com.FalaPraEle.dto.message.MessageCreationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ChatService chatService;

    public MessageService(MessageRepository messageRepository, ChatService chatService) {
        this.messageRepository = messageRepository;
        this.chatService = chatService;
    }

    public Message create(MessageCreationDTO data) {
        Message message = new Message().builder()
                .senderId(data.senderId())
                .chatId(data.chatId())
                .sentTime(data.sentTime())
                .originalMessage(data.originalMessage())
                .translatedMessage(data.translatedMessage())
                .build();

        chatService.addMessage(data.chatId(), message);

        return messageRepository.save(message);
    }

    public List<ChatMessageDTO> listMessagesByChatId(String chatId) {
        return messageRepository.findByChatId(chatId).stream()
                .map(message -> new ChatMessageDTO(
                        message.getSenderId(),
                        message.getOriginalMessage(),
                        message.getTranslatedMessage(),
                        message.getSentTime()
                )).toList();
    }
}
