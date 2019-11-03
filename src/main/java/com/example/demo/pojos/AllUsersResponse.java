package com.example.demo.pojos;

import java.util.List;

public class AllUsersResponse {
    List<UserResponse> users;

    public AllUsersResponse(List<UserResponse> users) {
        this.users = users;
    }

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }
}
