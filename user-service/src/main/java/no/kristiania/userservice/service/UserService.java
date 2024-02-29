package no.kristiania.userservice.service;

import no.kristiania.userservice.dto.UserDto;
import no.kristiania.userservice.entity.User;

import java.util.List;

public interface UserService {
    User getUserByUsername(String userName);

    List<User> getAllUsers();

    UserDto saveUser(UserDto userDto);
}
