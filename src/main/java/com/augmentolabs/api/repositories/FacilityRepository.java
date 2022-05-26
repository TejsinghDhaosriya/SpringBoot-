package com.augmentolabs.api.repositories;

import com.augmentolabs.api.models.Facilities;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface FacilityRepository extends CrudRepository<Facilities,Long> {

    List<Facilities> findAll();

    List<Facilities> findAllByName(String facilityName);

    List<Facilities> findAllByNameAndCreatedDateBetween(String facilityName, Date startDate, Date endDate);

    List<Facilities> findAllByCreatedDateBetween(Date startDate, Date endDate);
}
