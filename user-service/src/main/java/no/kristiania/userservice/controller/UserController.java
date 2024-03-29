package no.kristiania.userservice.controller;

import lombok.AllArgsConstructor;
import no.kristiania.userservice.dto.UserDto;
import no.kristiania.userservice.entity.User;
import no.kristiania.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        UserDto savedUserDto = userService.saveUser(userDto);

        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(params = "username")
    public ResponseEntity<User> getUserBYName(@RequestParam("name") String userName){
        User user = userService.getUserByUsername(userName);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
