package no.kristiania.userservice.service.impl;

import no.kristiania.userservice.dto.UserDto;
import no.kristiania.userservice.entity.User;
import no.kristiania.userservice.repository.UserRepository;
import no.kristiania.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByUsername(String userName) {
        return userRepository.findByUserName(userName);

    }

    @Override
    public UserDto saveUser() {
        return null;
    }
}
