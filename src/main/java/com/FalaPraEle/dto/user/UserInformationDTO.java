package com.FalaPraEle.dto.user;

import com.FalaPraEle.domain.entity.User;

import java.util.List;

public record UserInformationDTO
        (String name,
         String login,
         String password,
         String language,
         List<String> chatsIds,
         List<ContactsDTO> contacts
        ) { public UserInformationDTO(User user) {
        this(user.getName(), user.getLogin(), user.getPassword(), user.getLanguage(), user.getChatsId(),user.getContacts().stream().map(contact -> new ContactsDTO(contact.getName(), contact.getLanguage())).toList());
}
}
