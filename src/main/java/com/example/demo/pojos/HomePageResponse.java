package com.example.demo.pojos;

import java.util.List;

public class HomePageResponse {

    private String title;
    private int numberOfTourPackages;
    private int numberOfUsers;
    private List<TourPackageResponse> tourPackages;
    private List<UserResponse> users;

    public HomePageResponse(String title, int numberOfTourPackages, int numberOfUsers, List<TourPackageResponse> tourPackages, List<UserResponse> users) {
        this.title = title;
        this.numberOfTourPackages = numberOfTourPackages;
        this.numberOfUsers = numberOfUsers;
        this.tourPackages = tourPackages;
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfTourPackages() {
        return numberOfTourPackages;
    }

    public void setNumberOfTourPackages(int numberOfTourPackages) {
        this.numberOfTourPackages = numberOfTourPackages;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public List<TourPackageResponse> getTourPackages() {
        return tourPackages;
    }

    public void setTourPackages(List<TourPackageResponse> tourPackages) {
        this.tourPackages = tourPackages;
    }

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }
}
