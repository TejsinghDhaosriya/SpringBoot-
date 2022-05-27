package com.augmentolabs.api.facade;

import com.augmentolabs.api.models.*;
import com.augmentolabs.api.services.FacilityService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
public class FacilityFacadeTest {

    @InjectMocks
    FacilityFacade facilityFacade;

    @Mock
    FacilityService facilityService;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void shouldReturnAllInformationWhenInformationAtIsNotProvided() throws Exception {
        String facilityName = "abc";
        Date startDate = getDate("2021-02-12");
        Date endDate = getDate("2021-02-12");
        String informationAt = null;
        Facilities facility = getFacility();
        Buildings building = getBuilding();
        Floors floors = getFloors();
        Zones zones = getZones();
        Meters meters = getMeters();
        zones.setMeters(Collections.singletonList(meters));
        floors.setZones(Collections.singletonList(zones));
        building.setFloors(Collections.singletonList(floors));
        facility.setBuildings(Collections.singletonList(building));

        when(facilityService.search(facilityName,startDate,endDate)).thenReturn(Collections.singletonList(facility));
        List<Facilities> response  = facilityFacade.search(facilityName,startDate,endDate,informationAt);

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

        verify(facilityService,times(1)).search(facilityName,startDate,endDate);
    }

    @Test
    public void shouldReturnBuildingLevelInformation() throws Exception {
        String facilityName = "abc";
        Date startDate = getDate("2021-02-12");
        Date endDate = getDate("2021-02-12");
        String informationAt = "buildings";
        Facilities facility = getFacility();
        Buildings building = getBuilding();
        Floors floors = getFloors();
        Zones zones = getZones();
        Meters meters = getMeters();
        zones.setMeters(Collections.singletonList(meters));
        floors.setZones(Collections.singletonList(zones));
        building.setFloors(Collections.singletonList(floors));
        facility.setBuildings(Collections.singletonList(building));

        when(facilityService.search(facilityName,startDate,endDate)).thenReturn(Collections.singletonList(facility));
        List<Buildings> response  = facilityFacade.search(facilityName,startDate,endDate,informationAt);

        assertEquals(building.getId(),response.get(0).getId());
        assertEquals(building.getName(),response.get(0).getName());

        assertEquals(floors.getId(),response.get(0).getFloors().get(0).getId());
        assertEquals(floors.getName(),response.get(0).getFloors().get(0).getName());

        assertEquals(zones.getId(),response.get(0).getFloors().get(0).getZones().get(0).getId());
        assertEquals(zones.getName(),response.get(0).getFloors().get(0).getZones().get(0).getName());

        assertEquals(meters.getId(),response.get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getId());
        assertEquals(meters.getName(),response.get(0).getFloors().get(0).getZones().get(0).getMeters().get(0).getName());

        verify(facilityService,times(1)).search(facilityName,startDate,endDate);
    }

    @Test
    public void shouldReturnFloorsLevelInformation() throws Exception {
        String facilityName = "abc";
        Date startDate = getDate("2021-02-12");
        Date endDate = getDate("2021-02-12");
        String informationAt = "floors";
        Facilities facility = getFacility();
        Buildings building = getBuilding();
        Floors floors = getFloors();
        Zones zones = getZones();
        Meters meters = getMeters();
        zones.setMeters(Collections.singletonList(meters));
        floors.setZones(Collections.singletonList(zones));
        building.setFloors(Collections.singletonList(floors));
        facility.setBuildings(Collections.singletonList(building));

        when(facilityService.search(facilityName,startDate,endDate)).thenReturn(Collections.singletonList(facility));
        List<Floors> response  = facilityFacade.search(facilityName,startDate,endDate,informationAt);

        assertEquals(floors.getId(),response.get(0).getId());
        assertEquals(floors.getName(),response.get(0).getName());

        assertEquals(zones.getId(),response.get(0).getZones().get(0).getId());
        assertEquals(zones.getName(),response.get(0).getZones().get(0).getName());

        assertEquals(meters.getId(),response.get(0).getZones().get(0).getMeters().get(0).getId());
        assertEquals(meters.getName(),response.get(0).getZones().get(0).getMeters().get(0).getName());

        verify(facilityService,times(1)).search(facilityName,startDate,endDate);
    }


    @Test
    public void shouldReturnZonesLevelInformation() throws Exception {
        String facilityName = "abc";
        Date startDate = getDate("2021-02-12");
        Date endDate = getDate("2021-02-12");
        String informationAt = "zones";
        Facilities facility = getFacility();
        Buildings building = getBuilding();
        Floors floors = getFloors();
        Zones zones = getZones();
        Meters meters = getMeters();
        zones.setMeters(Collections.singletonList(meters));
        floors.setZones(Collections.singletonList(zones));
        building.setFloors(Collections.singletonList(floors));
        facility.setBuildings(Collections.singletonList(building));

        when(facilityService.search(facilityName,startDate,endDate)).thenReturn(Collections.singletonList(facility));
        List<Zones> response  = facilityFacade.search(facilityName,startDate,endDate,informationAt);

        assertEquals(zones.getId(),response.get(0).getId());
        assertEquals(zones.getName(),response.get(0).getName());

        assertEquals(meters.getId(),response.get(0).getMeters().get(0).getId());
        assertEquals(meters.getName(),response.get(0).getMeters().get(0).getName());

        verify(facilityService,times(1)).search(facilityName,startDate,endDate);
    }
    @Test
    public void shouldThrowErrorWhenInvalidInformationAtPassed() throws Exception {
        String facilityName = "abc";
        Date startDate = getDate("2021-02-12");
        Date endDate = getDate("2021-02-12");
        String informationAt = "region";
        Facilities facility = getFacility();
        Buildings building = getBuilding();
        Floors floors = getFloors();
        Zones zones = getZones();
        Meters meters = getMeters();
        zones.setMeters(Collections.singletonList(meters));
        floors.setZones(Collections.singletonList(zones));
        building.setFloors(Collections.singletonList(floors));
        facility.setBuildings(Collections.singletonList(building));

        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Invalid informationAt passed possible values are buildings,floors,zones");

        facilityFacade.search(facilityName,startDate,endDate,informationAt);

    }


}
