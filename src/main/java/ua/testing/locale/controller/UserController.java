package ua.testing.locale.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.testing.locale.dto.UserDTO;
import ua.testing.locale.dto.UsersDTO;
import ua.testing.locale.entity.User;
import ua.testing.locale.service.UserService;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "name", method = RequestMethod.POST)
    //@PostMapping(value = "name")
    public void nameController(UserDTO user){
        log.info("{}",userService.findByUserId(user));
        log.info("{}", user);
        userService.saveNewUser(User.builder()
                .nameEng(user.getNameEng())
                .nameUkr(user.getNameUkr())
                .build());
        log.info("{}", user);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public UsersDTO getAllUser(){
        log.info("{}",userService.getAllUsers());
        return userService.getAllUsers();
    }
}
