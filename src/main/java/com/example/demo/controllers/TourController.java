package com.example.demo.controllers;

import com.example.demo.pojos.GetAllToursResponse;
import com.example.demo.pojos.TourResponse;
import com.example.demo.services.TourService;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TourController {

    @Autowired
    private TourService service;

    @GetMapping("/allTours")
    public GetAllToursResponse getAllTours() {
        return new GetAllToursResponse(service.getAllTours());
    }

    @GetMapping("/getToursByPackageId/{tourPackageId}")
    public GetAllToursResponse getToursByPackageId(@PathVariable Long tourPackageId) {
        return new GetAllToursResponse(service.getToursByPackageId(tourPackageId));
    }

    @GetMapping("/expensiveTours")
    public GetAllToursResponse getExpensiveTours() {
        return new GetAllToursResponse(service.getExpensiveTours());
    }

    @GetMapping("/getToursByCriteria/{criteria}/{criteriaId}")
    public GetAllToursResponse getToursByCriteria(@PathVariable String criteria,
                                                  @PathVariable Long criteriaId) {
        return new GetAllToursResponse(service.getToursByCriteria(criteria, criteriaId));
    }
}
