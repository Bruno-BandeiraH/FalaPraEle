package com.FalaPraEle.domain.entity;

import com.FalaPraEle.domain.entity.enums.ChatType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "chats")
public class Chat {

    @Id
    private String id;
    private String name;
    private ChatType type;
    private List<Message> messages;
    private List<Long> membersIds;
    private LocalDateTime creationDate;
    private List<Long> moddersIds;
    private String preferredLanguage;


}
