package com.augmentolabs.api.services;

import com.augmentolabs.api.models.Facilities;
import com.augmentolabs.api.repositories.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class FacilityService {

    @Autowired
    FacilityRepository facilityRepository;


    public List<Facilities> search(String facilityName, Date startDate, Date endDate) {

        if(StringUtils.hasLength(facilityName) && startDate ==null && endDate ==null){
            return facilityRepository.findAllByName(facilityName);
        }
        else if(StringUtils.hasLength(facilityName) && startDate !=null && endDate !=null){
            return facilityRepository.findAllByNameAndCreatedDateBetween(facilityName,startDate,endDate);
        }
        else if(!StringUtils.hasLength(facilityName) && startDate !=null && endDate !=null){
            return facilityRepository.findAllByCreatedDateBetween(startDate,endDate);
        }
        else {
            return facilityRepository.findAll();
        }
    }
}
