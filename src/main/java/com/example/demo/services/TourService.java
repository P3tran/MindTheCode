package com.example.demo.services;

import com.example.demo.TourMapper;
import com.example.demo.pojos.Error;
import com.example.demo.pojos.GenericResponse;
import com.example.demo.pojos.Tour;
import com.example.demo.pojos.TourResponse;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {

    private TourMapper mapper;

    private TourRepository repository;

    private TourPackageRepository tourPackageRepository;

    public TourService(TourMapper mapper, TourRepository repository, TourPackageRepository tourPackageRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public GenericResponse<List<TourResponse>> getAllTours() {
        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList<>();

        for (Tour tour : retrievedTours) {
            TourResponse newTour = mapper.mapTourResponseFromTour(tour);
            newTour.setFinalPrice(600000);
            tours.add(newTour);
        }

        return new GenericResponse(tours);
/*        retrievedTours.forEach((tour)-> {

        });*/
    }

    public List<TourResponse> getToursByPackageId(Long tourPackageId) {
        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList<>();
        for (Tour tour : retrievedTours) {
            if (tour.getTourPackage() !=null && tour.getTourPackage().getId() == tourPackageId) {
                tours.add(mapper.mapTourResponseFromTour(tour));
            }
        }
        return tours;
    }

    public List<TourResponse> getExpensiveTours() {
        List<TourResponse> mappedTours = getAllTours().getData();
        List<TourResponse> tours = new ArrayList<>();
        for (TourResponse tour : mappedTours) {
            if (tour.getFinalPrice() > 500)
                tours.add(tour);
        }

        return tours;
    }

    public GenericResponse<List<TourResponse>> getToursByCriteria(String criteria, Long criteriaId) {
        Iterable<Tour> tours = repository.findAll();
        List<TourResponse> toursToReturn = new ArrayList<>();

        if (criteria.equals("tourPackage")) {

            if (!tourPackageRepository.findById(criteriaId).isPresent())
                return new GenericResponse<>(new Error(0, "Wrong Input", "Tourpackage with id " + criteriaId + " does not exist"));

            for (Tour tour : tours) {
                if (tour.getTourPackage().getId() == criteriaId) {
                    toursToReturn.add(mapper.mapTourResponseFromTour(tour));
                }
            }
        }
        return new GenericResponse<>(toursToReturn);
    }
}
