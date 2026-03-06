package com.FalaPraEle.controller;

import com.FalaPraEle.domain.entity.User;
import com.FalaPraEle.dto.user.UserCreationDTO;
import com.FalaPraEle.dto.user.UserInformationDTO;
import com.FalaPraEle.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserCreationDTO data, UriComponentsBuilder uriBuilder) {
        User user = userService.create(data);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserInformationDTO(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInformationDTO> getById(@RequestParam Long id){
        UserInformationDTO userData = userService.findById(id);
        return ResponseEntity.ok(userData);
    }
}
