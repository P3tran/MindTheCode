package com.example.demo.controllers;

import com.example.demo.pojos.Error;
import com.example.demo.pojos.GenericResponse;
import com.example.demo.pojos.GetAllToursResponse;
import com.example.demo.pojos.TourPackageResponse;
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
@RequestMapping("tour-office/")
public class TourController {

    private TourService service;

    public TourController(TourService service) {
        this.service = service;
    }

    @GetMapping("allTours")
    public ResponseEntity getAllTours() {
        GenericResponse<List<TourResponse>> response = service.getAllTours();
        if(response.getError() != null)
            return new ResponseEntity(response.getError(), null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity(new GetAllToursResponse(response.getData()),null, HttpStatus.OK);
    }

    @GetMapping("getToursByPackageId/{tourPackageId}")
    public ResponseEntity getToursByPackageId(@PathVariable Long tourPackageId) {
        try {
            return new  ResponseEntity(
                    new GetAllToursResponse(service.getToursByPackageId(tourPackageId)),
                    null,
                    HttpStatus.OK
            );
        } catch (Exception e) {
            e.printStackTrace();

            return new  ResponseEntity(
                     new Error(0, "Error" ,"Something went wrong please try again"),
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("expensiveTours")
    public GetAllToursResponse getExpensiveTours() {
        return new GetAllToursResponse(service.getExpensiveTours());
    }

    @GetMapping("getToursByCriteria/{criteria}/{criteriaId}")
    public ResponseEntity getToursByCriteria(@PathVariable String criteria,
                                                  @PathVariable Long criteriaId) {
        if(!criteria.equals("tourPackage"))
            return new ResponseEntity(
                    new Error(0, "Wrong Criteria", "The criteria input should be tourPackage"),
                    null,
                    HttpStatus.BAD_REQUEST
            );
        GenericResponse<List<TourResponse>> response = service.getToursByCriteria(criteria,criteriaId);
        if(response.getError() != null)
            return new ResponseEntity(
                    response.getError(),
                    null,
                    HttpStatus.BAD_REQUEST
            );

        return new ResponseEntity(
                new GetAllToursResponse(response.getData()),
                null,
                HttpStatus.OK);
    }
}
