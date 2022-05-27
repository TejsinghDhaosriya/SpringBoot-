package com.augmentolabs.api.utils;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UtilsTest {


    @Test
    public void shouldParseDateAndCreateDateObject() throws ParseException {
        String date = "2022-12-04";

        Date response = Utils.getDate(date);

        assertEquals(1670092200000L, response.getTime());
    }

    @Test(expected = ParseException.class)
    public void shouldThrowErrorWhileParsingInvalidDate() throws ParseException {
        String date = "2k22-12-4434";
        Utils.getDate(date);

    }


}
