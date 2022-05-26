package com.augmentolabs.api.facade;

import com.augmentolabs.api.models.Buildings;
import com.augmentolabs.api.models.Facilities;
import com.augmentolabs.api.models.Floors;
import com.augmentolabs.api.models.Zones;
import com.augmentolabs.api.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacilityFacade {

    @Autowired
    FacilityService facilityService;

    public List search(String facilityName, Date startDate, Date endDate, String informationAt) {
        if(!StringUtils.hasLength(informationAt)){
            return facilityService.search(facilityName,startDate,endDate);
        }
        List<Facilities> search = facilityService.search(facilityName, startDate, endDate);
        List response = new ArrayList();
        if("buildings".equalsIgnoreCase(informationAt)){
            return getBuildingLevelSearch(search);
        }
        if("floors".equalsIgnoreCase(informationAt)){
            return getFloorLevelSearch(search);
        }
        if("zones".equalsIgnoreCase(informationAt)){
            return getZoneLevelSearch(search);
        }
        return search;
    }

    private List<Buildings> getBuildingLevelSearch(List<Facilities> search) {
        List<Buildings> response = new ArrayList();
        search.forEach(s->{
            response.addAll(s.getBuildings());
        });
        return response;
    }

    private List<Floors> getFloorLevelSearch(List<Facilities> search) {
        List<Floors> response = new ArrayList();
        search.forEach(s->{
            List<Buildings> buildings = s.getBuildings();
            buildings.forEach(b->{
                response.addAll(b.getFloors());});
        });

        return response;
    }

    private List<Zones> getZoneLevelSearch(List<Facilities> search) {
        List<Zones> response = new ArrayList();
        search.forEach(s->{
            List<Buildings> buildings = s.getBuildings();
            buildings.forEach(b->{
                List<Floors> floors = b.getFloors();
                floors.forEach(f->{
                response.addAll(f.getZones());
                });
            });
        });

        return response;
    }
}
