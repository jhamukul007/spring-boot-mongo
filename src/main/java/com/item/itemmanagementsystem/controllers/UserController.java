package com.item.itemmanagementsystem.controllers;

import com.item.itemmanagementsystem.models.User;
import com.item.itemmanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
