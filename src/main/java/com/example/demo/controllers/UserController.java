package com.example.demo.controllers;

import com.example.demo.pojos.AllUsersResponse;
import com.example.demo.pojos.UserResponse;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/allUsers")
    public AllUsersResponse getAllUsers() {
        List<UserResponse> users = service.getAllUsers();
        AllUsersResponse response = new AllUsersResponse(users);
        return response;
    }
}
