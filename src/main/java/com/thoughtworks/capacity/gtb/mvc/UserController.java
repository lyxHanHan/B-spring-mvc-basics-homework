package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCar(@RequestBody User user) {
        userService.registUser(user);
    }

}
