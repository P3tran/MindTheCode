package com.example.demo;

import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.TourPackageResponse;
import org.springframework.stereotype.Component;

@Component
public class TourPackageMapper {

    public TourPackageResponse mapTourPackage(TourPackage tourPackage) {
        return new TourPackageResponse(
                tourPackage.getId(),
                mapTitle(tourPackage),
                tourPackage.getPrice()
        );
    }

    private String mapTitle(TourPackage tourPackage) {
        return tourPackage.getDest() + ": " + tourPackage.getDesc();
    }
}
