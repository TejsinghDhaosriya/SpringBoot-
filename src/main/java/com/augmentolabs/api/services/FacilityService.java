package com.augmentolabs.api.services;

import com.augmentolabs.api.repositories.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class FacilityService {

    @Autowired
    FacilityRepository facilityRepository;

    public List<Object> search(String facilityName, Date startDate, Date endDate, String informationAt) {
            return Collections.singletonList(facilityRepository.findAll());
    }
}
