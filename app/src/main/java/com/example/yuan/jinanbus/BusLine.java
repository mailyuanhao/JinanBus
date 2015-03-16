package com.example.yuan.jinanbus;

import android.util.Log;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 一条公交线
 * Created by Yuan on 2015/3/15.
 */
class BusLine {

    public static class Station {
        private String mId;
        private int mArea;
        private double mLat;
        private double mLng;
        private String mState;
        private String mStationName;
        private Date mUpdateTime;

        public String getId() {
            return mId;
        }

        public void setId(String id) {
            mId = id;
        }

        public int getArea() {
            return mArea;
        }

        public void setArea(int area) {
            mArea = area;
        }

        public double getLat() {
            return mLat;
        }

        public void setLat(double lat) {
            mLat = lat;
        }

        public double getLng() {
            return mLng;
        }

        public void setLng(double lng) {
            mLng = lng;
        }

        public String getState() {
            return mState;
        }

        public void setState(String state) {
            mState = state;
        }

        public String getStationName() {
            return mStationName;
        }

        public void setStationName(String stationName) {
            mStationName = stationName;
        }

        public Date getUpdateTime() {
            return mUpdateTime;
        }

        public void setUpdateTime(Date updateTime) {
            mUpdateTime = updateTime;
        }

        private static String sTAG = "Station";

        public Date string2Date(String strDate) {
            GregorianCalendar gc = new GregorianCalendar(1970, Calendar.JANUARY, 1);
            Date date = gc.getTime();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy h:mm:ss a");
                sdf.setDateFormatSymbols(DateFormatSymbols.getInstance(new Locale("en")));
                date = sdf.parse(strDate);
            }
            catch (ParseException e)
            {
                Log.d(sTAG, "ParseException" + e.toString());
            }

            return  date;
        }
    }
}
