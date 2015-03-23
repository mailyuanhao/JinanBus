package com.example.yuan.jinanbus;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 一条公交线
 * Created by Yuan on 2015/3/15.
 */
class BusLine implements Serializable{
    private static final String sTAG = "BusLine";
    private String mId;
    private int mArea;
    private String mLocalLineId;
    private String mEndStationName;
    private String mLineName;
    private String mLinePoints;
    private String mStartStationName;
    private String mState;
    private String mStationList;
    private final ArrayList<Station> mStations = new ArrayList<>();
    private String mTicketPrice;
    private String mOperationTime;
    private String mOwner;
    private String mUpdateTime;
    private String mDescrip;

    public static BusLine parse(String js) {
        BusLine bl = null;
        try {
            JSONObject jo = new JSONObject(js);
            int statusCode = jo.getJSONObject("status").getInt("code");
            if (statusCode == 0) {
                JSONObject jsonResult = jo.getJSONObject("result");
                if (jsonResult != null) {
                    bl = new BusLine();
                    parseJson2BusLine(bl, jsonResult);
                }
            }
        } catch (JSONException e) {
            Log.d(sTAG, "BusLine Error " + e);
        }
        return bl;
    }

    private static void parseJson2BusLine(BusLine bl, JSONObject jsonResult) throws JSONException {
        bl.mId = jsonResult.getString("id");
        bl.mArea = jsonResult.getInt("area");
        bl.mLocalLineId = jsonResult.getString("localLineId");
        bl.mEndStationName = jsonResult.getString("endStationName");
        bl.mLineName = jsonResult.getString("lineName");
        bl.mLinePoints = jsonResult.getString("linePoints");
        bl.mStartStationName = jsonResult.getString("startStationName");
        bl.mState = jsonResult.getString("state");
        bl.mStationList = jsonResult.getString("stationList");
        makeStations(bl, jsonResult);
        bl.mTicketPrice = jsonResult.getString("ticketPrice");
        bl.mOperationTime = jsonResult.getString("operationTime");
        bl.mOwner = jsonResult.getString("owner");
        bl.mUpdateTime = jsonResult.getString("updateTime");
        bl.mDescrip = jsonResult.optString("descrip", "无");
    }

    private static void makeStations(BusLine bl, JSONObject jsonResult) throws JSONException {
        JSONArray jsonStations = jsonResult.getJSONArray("stations");
        for (int i = 0; i < jsonStations.length(); i++) {
            JSONObject jsonStation = (JSONObject) jsonStations.get(i);
            Station station = Station.makeStation(jsonStation);
            if (station != null) {
                bl.mStations.add(station);
            }
        }
    }

    public static Date string2Date(String strDate) {
        GregorianCalendar gc = new GregorianCalendar(1970, Calendar.JANUARY, 1);
        Date date = gc.getTime();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.US);
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            Log.d(sTAG, "ParseException" + e.toString());
        }

        return date;
    }

    public String getId() {
        return mId;
    }


    public int getArea() {
        return mArea;
    }

    public String getLocalLineId() {
        return mLocalLineId;
    }

    public String getEndStationName() {
        return mEndStationName;
    }

    public String getLineName() {
        return mLineName;
    }

    public String getLinePoints() {
        return mLinePoints;
    }

    public String getStartStationName() {
        return mStartStationName;
    }

    public String getState() {
        return mState;
    }

    public String getStationList() {
        return mStationList;
    }

    public ArrayList<Station> getStations() {
        return mStations;
    }

    public String getTicketPrice() {
        return mTicketPrice;
    }

    public String getOperationTime() {
        return mOperationTime;
    }

    public String getOwner() {
        return mOwner;
    }

    public String getUpdateTime() {
        return mUpdateTime;
    }

    public String getDescrip() {
        return mDescrip;
    }

    public static class Station {
        private String mId;
        private int mArea;
        private double mLat;
        private double mLng;
        private String mState;
        private String mStationName;
        private Date mUpdateTime;

        public static Station makeStation(JSONObject jj) {
            Station s = null;
            if (jj != null) {
                try {
                    s = new Station();
                    s.setId(jj.getString("id"));
                    s.setArea(jj.getInt("area"));
                    s.setLat(jj.getDouble("lat"));
                    s.setLng(jj.getDouble("lng"));
                    s.setState(jj.getString("state"));
                    s.setStationName(jj.getString("stationName"));
                    s.setUpdateTime(string2Date(jj.getString("updateTime")));
                } catch (JSONException e) {
                    Log.d(sTAG, "构造Station失败 " + e);
                }
            }
            return s;
        }

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

        private static final String sTAG = "Station";
    }

}
