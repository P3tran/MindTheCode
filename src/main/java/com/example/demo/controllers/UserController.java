package com.example.demo.controllers;

import com.example.demo.InvalidUserStatusException;
import com.example.demo.pojos.AllUsersResponse;
import com.example.demo.pojos.Error;
import com.example.demo.pojos.UserResponse;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getUsersByStatus(@PathVariable String status) {
        try {
            return new ResponseEntity(new AllUsersResponse(service.getUsersByStatus(status)), null, HttpStatus.OK);
        } catch (InvalidUserStatusException e) {
            return new ResponseEntity(
                    new Error(
                            0,
                            "Invalid Status",
                            "status must be new, platinu, loyal, gold"),
                    null,
                    HttpStatus.BAD_REQUEST);
        }
    }
}
