package com.FalaPraEle.dto.message;

import java.time.LocalDateTime;

public record ChatMessageDTO(
        Long senderId,
        String originalMessage,
        String translatedMessage,
        LocalDateTime sentTime
) {
}
