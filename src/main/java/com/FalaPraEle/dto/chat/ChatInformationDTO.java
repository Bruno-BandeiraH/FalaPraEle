package com.FalaPraEle.dto.chat;

import com.FalaPraEle.domain.entity.Chat;
import com.FalaPraEle.domain.entity.enums.ChatType;
import com.FalaPraEle.dto.message.OriginalMessagesDTO;

import java.time.LocalDateTime;
import java.util.List;

public record ChatInformationDTO(
        ChatType type,
        List<Long> membersIds,
        LocalDateTime creationDate,
        String preferredLanguage,
        List<OriginalMessagesDTO> messages
) {
    public ChatInformationDTO(Chat chat) {
        this(chat.getType(), chat.getMembersIds(), chat.getCreationDate(),
                chat.getPreferredLanguage(),
                chat.getMessages().stream().map(
                        message -> new OriginalMessagesDTO(message.getSenderId(), message.getOriginalMessage(), message.getSentTime())
                ).toList());
    }
}
