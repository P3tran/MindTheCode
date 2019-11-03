package com.example.demo.services;

import com.example.demo.UsersMapper;
import com.example.demo.pojos.User;
import com.example.demo.pojos.UserResponse;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    UsersMapper mapper;

    public List<UserResponse> getAllUsers() {
        return mapper.mapUsers(repository.findAll());
    }

    public List<UserResponse> getUsersByStatus(String status) {
        Iterable<User> retrievedUsers = repository.findAll();
        List<UserResponse> users = new ArrayList<>();
        for (User user : retrievedUsers) {
            if (String.valueOf(user.getStatus()).equalsIgnoreCase(status)) {
                UserResponse userToAdd = mapper.mapUserToUserResponse(user);
                users.add(userToAdd);
            }
        }

        return users;
    }
}
