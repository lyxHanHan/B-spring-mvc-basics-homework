package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCar(@Valid @RequestBody User user) {
        userService.registUser(user);
    }


    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public void signIn(@Valid @RequestParam String username, @RequestParam String password) {
        userService.signIn(username,password);
    }

}
