package com.FalaPraEle.dto.chat;

import com.FalaPraEle.domain.entity.enums.ChatType;

import java.time.LocalDateTime;
import java.util.List;

public record ChatCreationDTO(
        String name,
        ChatType type,
        List<Long> membersIds,
        List<Long> moddersIds,
        String preferredLanguage,
        LocalDateTime creationDate
                ) {
}
