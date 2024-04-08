package com.acciojob.Book.My.Show.Application.controller;

import com.acciojob.Book.My.Show.Application.entity.User;
import com.acciojob.Book.My.Show.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
