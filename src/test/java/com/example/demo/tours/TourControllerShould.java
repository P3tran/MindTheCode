package com.example.demo.tours;

import com.example.demo.controllers.TourController;
import com.example.demo.pojos.Error;
import com.example.demo.pojos.GenericResponse;
import com.example.demo.pojos.TourResponse;
import com.example.demo.services.TourService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class TourControllerShould {

    TourController controller;

    @Mock
    TourService service;

    @Mock
    TourResponse tour1;

    @Mock
    TourResponse tour2;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        List<TourResponse> mockedTours = new ArrayList<>();
        mockedTours.add(tour1);
        mockedTours.add(tour2);
        GenericResponse<List<TourResponse>> mockedResponse = new GenericResponse(mockedTours);
        when(service.getAllTours()).thenReturn(mockedResponse);
        controller = new TourController(service);
    }

    @Test
    public void returnAllTours() {
        ResponseEntity<List<TourResponse>> actual = controller.getAllTours();

        Assert.assertThat(actual.getBody(), CoreMatchers.hasItems(tour1, tour2));
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void returnsErrorWhenSeviceFails() {
        Error error = mockServiceFailure();
        ResponseEntity<List<TourResponse>> actual = controller.getAllTours();
        Assert.assertEquals(error, actual.getBody());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actual.getStatusCode());
    }

    private Error mockServiceFailure() {
        Error error = new Error(0, "Error", "Something went wrong");
        when(service.getAllTours()).thenReturn(new GenericResponse<>(error));
        controller = new TourController(service);
        return error;
    }


}
