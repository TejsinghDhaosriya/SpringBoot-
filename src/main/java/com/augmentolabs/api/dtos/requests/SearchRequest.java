package com.augmentolabs.api.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
    private Date startDate;
    private Date endDate;
    private String facilityName;
    private String informationAt;
}
