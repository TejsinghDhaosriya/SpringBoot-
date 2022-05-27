package com.augmentolabs.api.controllers;

import com.augmentolabs.api.facade.FacilityFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.augmentolabs.api.utils.Utils.getDate;

@RestController
@RequestMapping("/api")
@Slf4j
public class SearchController {

    @Autowired
    private FacilityFacade facilityFacade;

    @GetMapping("/search")
    public ResponseEntity getSearch(@RequestParam(value = "facilityName", required = false) String facilityName,
                                    @RequestParam(value = "startDate", required = false) String startDate,
                                    @RequestParam(value = "endDate", required = false) String endDate,
                                    @RequestParam(value = "informationAt", required = false) String informationAt
    ) {
        try {
            return new ResponseEntity(facilityFacade.search(facilityName, getDate(startDate), getDate(endDate), informationAt), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
