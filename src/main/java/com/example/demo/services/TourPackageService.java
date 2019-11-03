package com.example.demo.services;

import com.example.demo.TourPackageMapper;
import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.TourPackageResponse;
import com.example.demo.repositories.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourPackageService {

    @Autowired
    private TourPackageRepository repository;

    @Autowired
    private TourPackageMapper mapper;

    public List<TourPackageResponse> getAllTourPackages() {
        List<TourPackageResponse> tourPackages = new ArrayList<>();
        Iterable<TourPackage> retrievedTourPackages = repository.findAll();
        for (TourPackage tourPackage : retrievedTourPackages) {
            tourPackages.add(mapper.mapTourPackage(tourPackage));
        }

        return tourPackages;
    }
}
