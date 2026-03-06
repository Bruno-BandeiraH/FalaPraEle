package com.FalaPraEle.dto.message;

import java.time.LocalDateTime;

public record OriginalMessagesDTO(
        Long senderId,
        String originalMessage,
        LocalDateTime sentTime
) {
}
