package com.augmentolabs.api.facade;

import com.augmentolabs.api.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        return facilityService.search(facilityName, startDate, endDate);
    }
}
