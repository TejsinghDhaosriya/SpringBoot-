package com.augmentolabs.api.controllers;

import com.augmentolabs.api.facade.FacilityFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

import static com.augmentolabs.api.utils.utils.getDate;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTests {


    @InjectMocks
    private SearchController searchController;

    @Mock
    private FacilityFacade facilityFacade;


    @Test
    public void shouldCallSearchAPI() throws ParseException {
        String facilityName = "abc";
        String startDate = "2021-02-12";
        String endDate = "2021-02-12";
        String informationAt = "zones";
        searchController.getSearch(facilityName, startDate, endDate, informationAt);
        verify(facilityFacade, times(1)).search(facilityName, getDate(startDate), getDate(endDate), informationAt);
    }

    @Test
    public void shouldThrowErrorWhenCallSearchAPI() throws ParseException {
        String facilityName = "abc";
        String startDate = "2021-02-12";
        String endDate = "2021-02-12";
        String informationAt = "zones";
        when(facilityFacade.search(any(), any(), any(), any())).thenThrow(NullPointerException.class);
        ResponseEntity responseEntity = searchController.getSearch(facilityName, startDate, endDate, informationAt);
        assertEquals("404 NOT_FOUND", responseEntity.getStatusCode().toString());
        verify(facilityFacade, times(1)).search(facilityName, getDate(startDate), getDate(endDate), informationAt);
    }
}
