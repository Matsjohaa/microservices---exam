package no.kristiania.userservice.service;

import no.kristiania.userservice.dto.UserDto;
import no.kristiania.userservice.entity.User;

public interface UserService {
    User getUserByUsername(String userName);

    UserDto saveUser();
}
