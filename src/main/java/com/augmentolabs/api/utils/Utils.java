package com.augmentolabs.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static final String DB_NAME = "meters";

    public static final String INVALID_INFORMATION_AT_PASSED_POSSIBLE_VALUES_ARE_BUILDINGS_FLOORS_ZONES = "Invalid informationAt passed possible values are buildings,floors,zones";

    public static Date getDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
