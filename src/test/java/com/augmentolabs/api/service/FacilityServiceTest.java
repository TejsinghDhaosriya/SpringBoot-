package com.augmentolabs.api.service;

import com.augmentolabs.api.models.*;
import com.augmentolabs.api.repositories.FacilityRepository;
import com.augmentolabs.api.services.FacilityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.augmentolabs.api.fixtures.FacilityFixture.*;
import static com.augmentolabs.api.utils.Utils.getDate;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FacilityServiceTest {

    @InjectMocks
    private FacilityService facilityService;

    @Mock
    private FacilityRepository facilityRepository;

    @Test
    public void shouldReturnInformationWhenOnlyFacilityNameIsProvided() throws Exception {
        String facilityName = "abc";
        Date startDate = null;
        Date endDate = null;
        Facilities facility = getFacility();
        Buildings building = getBuilding();
        Floors floors = getFloors();
        Zones zones = getZones();
        Meters meters = getMeters();
        zones.setMeters(Collections.singletonList(meters));
        floors.setZones(Collections.singletonList(zones));
        building.setFloors(Collections.singletonList(floors));
        facility.setBuildings(Collections.singletonList(building));

        when(facilityRepository.findAllByName(facilityName)).thenReturn(Collections.singletonList(facility));
        List<Facilities> response  = facilityService.search(facilityName,startDate,endDate);

        assertEquals(facility.getId(),response.get(0).getId());
        assertEquals(facility.getName(),response.get(0).getName());
        assertEquals(facility.getCityId(),response.get(0).getCityId());

        assertEquals(building.getId(),response.get(0).getBuildings().get(0).getId());
        assertEquals(building.getName(),response.get(0).getBuildings().get(0).getName());

        assertEquals(floors.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getId());
        assertEquals(floors.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getName());

        assertEquals(zones.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getId());
        assertEquals(zones.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getName());

        assertEquals(meters.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getId());
        assertEquals(meters.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getName());

        verify(facilityRepository,times(1)).findAllByName(facilityName);
        verify(facilityRepository,times(0)).findAllByNameAndCreatedDateBetween(facilityName,startDate,endDate);
        verify(facilityRepository,times(0)).findAllByCreatedDateBetween(startDate,endDate);
        verify(facilityRepository,times(0)).findAll();
    }

    @Test
    public void shouldReturnInformationWhenFacilityNameAndStartEndDateIsProvided() throws Exception {
        String facilityName = "abc";
        Date startDate = getDate("2021-02-12");
        Date endDate = getDate("2021-02-12");
        Facilities facility = getFacility();
        Buildings building = getBuilding();
        Floors floors = getFloors();
        Zones zones = getZones();
        Meters meters = getMeters();
        zones.setMeters(Collections.singletonList(meters));
        floors.setZones(Collections.singletonList(zones));
        building.setFloors(Collections.singletonList(floors));
        facility.setBuildings(Collections.singletonList(building));

        when(facilityRepository.findAllByNameAndCreatedDateBetween(facilityName,startDate,endDate)).thenReturn(Collections.singletonList(facility));
        List<Facilities> response  = facilityService.search(facilityName,startDate,endDate);

        assertEquals(facility.getId(),response.get(0).getId());
        assertEquals(facility.getName(),response.get(0).getName());
        assertEquals(facility.getCityId(),response.get(0).getCityId());

        assertEquals(building.getId(),response.get(0).getBuildings().get(0).getId());
        assertEquals(building.getName(),response.get(0).getBuildings().get(0).getName());

        assertEquals(floors.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getId());
        assertEquals(floors.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getName());

        assertEquals(zones.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getId());
        assertEquals(zones.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getName());

        assertEquals(meters.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getId());
        assertEquals(meters.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getName());

        verify(facilityRepository,times(0)).findAllByName(facilityName);
        verify(facilityRepository,times(1)).findAllByNameAndCreatedDateBetween(facilityName,startDate,endDate);
        verify(facilityRepository,times(0)).findAllByCreatedDateBetween(startDate,endDate);
        verify(facilityRepository,times(0)).findAll();
    }

    @Test
    public void shouldReturnInformationWhenOnlyStartEndDateIsProvided() throws Exception {
        String facilityName = null;
        Date startDate = getDate("2021-02-12");
        Date endDate = getDate("2021-02-12");
        Facilities facility = getFacility();
        Buildings building = getBuilding();
        Floors floors = getFloors();
        Zones zones = getZones();
        Meters meters = getMeters();
        zones.setMeters(Collections.singletonList(meters));
        floors.setZones(Collections.singletonList(zones));
        building.setFloors(Collections.singletonList(floors));
        facility.setBuildings(Collections.singletonList(building));

        when(facilityRepository.findAllByCreatedDateBetween(startDate,endDate)).thenReturn(Collections.singletonList(facility));
        List<Facilities> response  = facilityService.search(facilityName,startDate,endDate);

        assertEquals(facility.getId(),response.get(0).getId());
        assertEquals(facility.getName(),response.get(0).getName());
        assertEquals(facility.getCityId(),response.get(0).getCityId());

        assertEquals(building.getId(),response.get(0).getBuildings().get(0).getId());
        assertEquals(building.getName(),response.get(0).getBuildings().get(0).getName());

        assertEquals(floors.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getId());
        assertEquals(floors.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getName());

        assertEquals(zones.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getId());
        assertEquals(zones.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getName());

        assertEquals(meters.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getId());
        assertEquals(meters.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getName());

        verify(facilityRepository,times(0)).findAllByName(facilityName);
        verify(facilityRepository,times(0)).findAllByNameAndCreatedDateBetween(facilityName,startDate,endDate);
        verify(facilityRepository,times(1)).findAllByCreatedDateBetween(startDate,endDate);
        verify(facilityRepository,times(0)).findAll();
    }

    @Test
    public void shouldReturnAllInformationWhenNoParamIsPassed() throws Exception {
        String facilityName = null;
        Date startDate = null;
        Date endDate = null;
        Facilities facility = getFacility();
        Buildings building = getBuilding();
        Floors floors = getFloors();
        Zones zones = getZones();
        Meters meters = getMeters();
        zones.setMeters(Collections.singletonList(meters));
        floors.setZones(Collections.singletonList(zones));
        building.setFloors(Collections.singletonList(floors));
        facility.setBuildings(Collections.singletonList(building));

        when(facilityRepository.findAll()).thenReturn(Collections.singletonList(facility));
        List<Facilities> response  = facilityService.search(facilityName,startDate,endDate);

        assertEquals(facility.getId(),response.get(0).getId());
        assertEquals(facility.getName(),response.get(0).getName());
        assertEquals(facility.getCityId(),response.get(0).getCityId());

        assertEquals(building.getId(),response.get(0).getBuildings().get(0).getId());
        assertEquals(building.getName(),response.get(0).getBuildings().get(0).getName());

        assertEquals(floors.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getId());
        assertEquals(floors.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getName());

        assertEquals(zones.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getId());
        assertEquals(zones.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getName());

        assertEquals(meters.getId(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getId());
        assertEquals(meters.getName(),response.get(0).getBuildings().get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getName());

        verify(facilityRepository,times(0)).findAllByName(facilityName);
        verify(facilityRepository,times(0)).findAllByNameAndCreatedDateBetween(facilityName,startDate,endDate);
        verify(facilityRepository,times(0)).findAllByCreatedDateBetween(startDate,endDate);
        verify(facilityRepository,times(1)).findAll();
    }

}
