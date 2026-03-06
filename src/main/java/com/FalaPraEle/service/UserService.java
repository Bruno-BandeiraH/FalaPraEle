package com.FalaPraEle.service;

import com.FalaPraEle.domain.entity.User;
import com.FalaPraEle.domain.repository.UserRepository;
import com.FalaPraEle.dto.user.ContactsDTO;
import com.FalaPraEle.dto.user.UserInformationDTO;
import com.FalaPraEle.dto.user.UserCreationDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserCreationDTO data) {
        User user = User.builder()
                .name(data.name())
                .language(data.language())
                .login(data.login())
                .password(data.password())
                .contacts(new ArrayList<>())
                .chatsId(new ArrayList<>())
                .build();

        return userRepository.save(user);
    }

    public UserInformationDTO findById(Long userId) {
        User user=  userRepository.findById(userId).get();
        return new UserInformationDTO(user.getName(), user.getLogin(),
                user.getPassword(), user.getLanguage(), user.getChatsId(), user.getContacts()
                .stream().map( contact -> new ContactsDTO(contact.getName(), contact.getLanguage())
        ).collect(Collectors.toList()));
    }
}
