package com.example.demo.pojos;

import java.util.List;

public class GetAllToursResponse {

    private List<TourResponse> toursResponses;

    public GetAllToursResponse(List<TourResponse> toursResponses) {
        this.toursResponses = toursResponses;
    }

    public List<TourResponse> getToursResponses() {
        return toursResponses;
    }

    public void setToursResponses(List<TourResponse> toursResponses) {
        this.toursResponses = toursResponses;
    }
}
