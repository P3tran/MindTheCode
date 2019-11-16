package com.example.demo.controllers;

import com.example.demo.pojos.AllUsersResponse;
import com.example.demo.pojos.UserResponse;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tour-office/")
public class UserController {

    @Autowired
    private
    UserService service;

    @GetMapping("allUsers")
    public AllUsersResponse getAllUsers() {
        List<UserResponse> users = service.getAllUsers();
        AllUsersResponse response = new AllUsersResponse(users);
        return response;
    }

    @GetMapping("userByStatus/{status}")
    public AllUsersResponse getUsersByStatus(@PathVariable String status) {
        return new AllUsersResponse(service.getUsersByStatus(status));
    }
}
