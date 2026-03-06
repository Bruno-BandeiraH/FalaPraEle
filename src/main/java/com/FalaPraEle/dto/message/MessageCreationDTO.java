package com.FalaPraEle.dto.message;

import java.time.LocalDateTime;

public record MessageCreationDTO(
        Long senderId,
        String chatId,
        String originalMessage,
        String translatedMessage,
        LocalDateTime sentTime
) {
}
