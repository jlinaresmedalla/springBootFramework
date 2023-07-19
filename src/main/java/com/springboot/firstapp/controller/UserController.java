package com.springboot.firstapp.controller;

import com.springboot.firstapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public User user;




}
