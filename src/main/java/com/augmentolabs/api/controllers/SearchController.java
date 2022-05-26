package com.augmentolabs.api.controllers;

import com.augmentolabs.api.facade.FacilityFacade;
import com.augmentolabs.api.services.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
@Slf4j
public class SearchController {

    @Autowired
    private FacilityFacade facilityFacade;

    @GetMapping("/search")
    public ResponseEntity getSearch(@RequestParam(value = "facilityName", required=false)  String facilityName,
                                    @RequestParam(value = "startDate", required=false) Date startDate,
                                    @RequestParam(value = "endDate", required=false) Date endDate,
                                    @RequestParam(value = "informationAt", required=false) String informationAt
                                    ){
        try{

            return new ResponseEntity(facilityFacade.search(facilityName,startDate,endDate,informationAt), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
}
