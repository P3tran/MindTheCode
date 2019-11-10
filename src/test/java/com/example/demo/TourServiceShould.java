package com.example.demo;

import com.example.demo.pojos.Tour;
import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.TourResponse;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import com.example.demo.services.TourService;
import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.*;
import org.mockito.internal.matchers.Any;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class TourServiceShould {

    private TourService service;

    TourResponse tourResponseFromMaper;

    @Mock
    private TourRepository tourRepository;

    @Mock
    private TourPackageRepository tourPackageRepository;

    @Mock
    private TourMapper mapper;

    private Iterable<Tour> mockedTours = new ArrayList<Tour>() {
        {
            add(new Tour(1, 1000, 400, "Da best tour", "shorty","longy", new TourPackage("package desc dat best", 3000, "Ionio")));
            add(new Tour(2, 1200, 500, "Da 2 best tour", "2 shorty","2 longy", new TourPackage("2 package desc dat best", 3000, "2 Ionio")));
        }
    };

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(tourRepository.findAll()).thenReturn(mockedTours);
        tourResponseFromMaper = new TourResponse(1, 1000, 400, 600, "title", "short", "long", "tp title");
        when(mapper.mapTourResponseFromTour(any())).thenReturn(tourResponseFromMaper);
        service = new TourService(mapper, tourRepository, tourPackageRepository);
    }

    @Test
    public void retrieveToursFromRepository() {
        service.getAllTours();
        Mockito.verify(tourRepository).findAll();
    }

    @Test
    public void usesTourMapper() {
        service.getAllTours();
        Mockito.verify(mapper, times(2)).mapTourResponseFromTour(any());
    }

    @Test
    @Ignore
    public void returnsListOfTourResponse() {
        List<TourResponse> output = service.getAllTours();
        Assert.assertEquals(2, output.size());
        List<TourResponse> expectedList = new ArrayList<>();
        expectedList.add(tourResponseFromMaper);
        expectedList.add(tourResponseFromMaper);
        Assert.assertThat(output, CoreMatchers.hasItems(tourResponseFromMaper, tourResponseFromMaper));
    }
}
