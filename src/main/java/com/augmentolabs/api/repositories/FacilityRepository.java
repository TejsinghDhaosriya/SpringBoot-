package com.augmentolabs.api.repositories;

import com.augmentolabs.api.models.Facilities;
import org.springframework.data.repository.CrudRepository;

public interface FacilityRepository extends CrudRepository<Facilities,Long> {
}
