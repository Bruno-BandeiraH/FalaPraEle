package com.FalaPraEle.service;

import com.FalaPraEle.domain.entity.Chat;
import com.FalaPraEle.domain.entity.Message;
import com.FalaPraEle.domain.repository.ChatRepository;
import com.FalaPraEle.domain.repository.UserRepository;
import com.FalaPraEle.dto.chat.ChatCreationDTO;
import com.FalaPraEle.dto.chat.ChatInformationDTO;
import com.FalaPraEle.dto.message.MessageCreationDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public ChatService(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    public Chat create(ChatCreationDTO data) {
        Chat chat = new Chat().builder()
                .name(data.name())
                .type(data.type())
                .membersIds(data.membersIds())
                .moddersIds(data.moddersIds())
                .preferredLanguage(data.preferredLanguage())
                .creationDate(data.creationDate())
                .messages(new ArrayList<>())
                .build();

        return chatRepository.save(chat);
    }

    public ChatInformationDTO findById(String id) {
        Chat chat = chatRepository.findById(id).get();
        return new ChatInformationDTO(chat);

    }

    public void addMessage(String chatId, Message message) {
        Chat chat = chatRepository.findById(chatId).get();
        chat.getMessages().add(message);
        chatRepository.save(chat);
    }
}
