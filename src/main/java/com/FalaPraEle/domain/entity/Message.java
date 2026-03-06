package com.FalaPraEle.domain.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private Long senderId;
    private String chatId;
    private String originalMessage;
    private String translatedMessage;
    private LocalDateTime sentTime;
}
