package com.augmentolabs.api.fixtures;

import com.augmentolabs.api.models.*;

import java.util.Date;

public class FacilityFixture {

    public static Facilities getFacility() {
        return Facilities.builder().id(23L).cityId(2L).name("xyz").createdDate(new Date()).enabled(true).active(true).build();
    }
    public static Buildings getBuilding() {
        return Buildings.builder().id(23L).name("alok nagar").createdDate(new Date()).enabled(true).active(true).build();
    }
    public static Floors getFloors() {
        return Floors.builder().id(23L).name("first floor").createdDate(new Date()).enabled(true).active(true).build();
    }

    public static Zones getZones() {
        return Zones.builder().id(23L).name("lowe zone").createdDate(new Date()).enabled(true).active(true).build();
    }

    public static Meters getMeters() {
        return Meters.builder().id(23L).name("water meter").createdDate(new Date()).enabled(true).active(true).build();
    }
}
