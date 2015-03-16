package com.example.yuan.jinanbus;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class StationTest {
    @Test
    public void testStationDate() throws Exception{
        {
            BusLine.Station station = new BusLine.Station();
            Date d1 = station.string2Date("Sep 3, 2014 7:28:00 AM");
            GregorianCalendar gc1 = new GregorianCalendar(2014, Calendar.SEPTEMBER, 3, 7, 28, 00);
            assertEquals(d1, gc1.getTime());
        }

        {
            BusLine.Station station = new BusLine.Station();
            Date d1 = station.string2Date("Aug 16, 2014 8:15:05 AM");
            GregorianCalendar gc1 = new GregorianCalendar(2014, Calendar.AUGUST, 16, 8, 15, 05);
            assertEquals(d1, gc1.getTime());
        }

    }
}