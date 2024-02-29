package no.kristiania.userservice.service.impl;

import lombok.AllArgsConstructor;
import no.kristiania.userservice.dto.UserDto;
import no.kristiania.userservice.entity.User;
import no.kristiania.userservice.repository.UserRepository;
import no.kristiania.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List <User> users = userRepository.findAll();

        return users;
    }

    @Override
    public User getUserByUsername(String userName) {
        return userRepository.findByUserName(userName);

    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getEmail(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getRole()
        );
        User savedUser = userRepository.save(user);

        UserDto savedUserDto = new UserDto(
                userDto.getId(),
                savedUser.getEmail(),
                savedUser.getUserName(),
                savedUser.getPassword(),
                savedUser.getRole()
        );

        return savedUserDto;
    }
}
