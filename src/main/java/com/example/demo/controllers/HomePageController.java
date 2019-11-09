package com.example.demo.controllers;

import com.example.demo.pojos.HomePageResponse;
import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.TourPackageResponse;
import com.example.demo.pojos.UserResponse;
import com.example.demo.services.TourPackageService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomePageController {

    @Autowired
    UserService userService;

    @Autowired
    TourPackageService tourPackageService;

    @GetMapping("/home")
    public HomePageResponse getHomePage() {
        List<TourPackageResponse> tourPackages = tourPackageService.getAllTourPackages();
        List<UserResponse> users = userService.getAllUsers();
        int numberOfTourPackages = tourPackages.size();
        int numberOfUsers = users.size();
        String title = "Home Page";
        HomePageResponse response = new HomePageResponse(title, numberOfTourPackages, numberOfUsers, tourPackages, users);
        return response;
    }
}
