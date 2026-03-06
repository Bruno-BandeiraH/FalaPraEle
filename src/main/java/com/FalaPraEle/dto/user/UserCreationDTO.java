package com.FalaPraEle.dto.user;

public record UserCreationDTO(
        String name,
        String login,
        String password,
        String language
) {
}
