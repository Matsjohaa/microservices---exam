package no.kristiania.userservice.controller;

import lombok.AllArgsConstructor;
import no.kristiania.userservice.dto.UserDto;
import no.kristiania.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(){
        return null;
    }
}
