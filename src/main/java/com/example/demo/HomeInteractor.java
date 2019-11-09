package com.example.demo;

import com.example.demo.pojos.HomePageResponse;
import com.example.demo.pojos.TourPackageResponse;
import com.example.demo.pojos.UserResponse;
import com.example.demo.services.TourPackageService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeInteractor {

    @Autowired
    UserService userService;

    @Autowired
    TourPackageService tourPackageService;

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
