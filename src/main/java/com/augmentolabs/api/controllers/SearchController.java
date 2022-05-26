package com.augmentolabs.api.controllers;

import com.augmentolabs.api.services.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class SearchController {

    @Autowired
    private FacilityService facilityService;

    @GetMapping("/search")
    public ResponseEntity getSearch(@RequestParam String facilityName){
        try{

            return new ResponseEntity(facilityService.search(facilityName), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
}
