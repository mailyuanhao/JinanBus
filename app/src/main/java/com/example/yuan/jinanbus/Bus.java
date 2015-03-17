package com.example.yuan.jinanbus;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * 代表单独的一辆Bus
 * Created by Yuan on 2015/3/15.
 */
class Bus {
    private String mBusId;
    private double mLng;
    private double mLat;
    private double mVelocity;
    private String mIsArrvLft;
    private int mStationSeqNum;
    private String mBuslineId;
    private Date mActTime;
    private String mCardId;
    private String mOrgName;
    private boolean mIsArriveDest;
    private int mDualSerialNum;

    private static String sTAG = "Bus";

    public static ArrayList<Bus> parse(String jsonString) {
        ArrayList<Bus> buses = new ArrayList<>();
        try {
            JSONObject busesJson = new JSONObject(jsonString);
            int status = busesJson.getJSONObject("status").getInt("code");
            if (status == 0) {
                JSONArray busJsonArray = busesJson.getJSONArray("result");
                for (int i = 0; i < busJsonArray.length(); i++) {
                    JSONObject busJson = busJsonArray.getJSONObject(i);
                    Bus bus = new Bus();
                    bus.setBusId(busJson.getString("busId"));
                    bus.setLng(busJson.getDouble("lng"));
                    bus.setLat(busJson.getDouble("lat"));
                    bus.setVelocity(busJson.getDouble("velocity"));
                    bus.setIsArrvLft(busJson.optString("isArrvLft", "-1"));
                    bus.setStationSeqNum(busJson.getInt("stationSeqNum"));
                    bus.setBuslineId(busJson.getString("buslineId"));
                    bus.setActTime(BusLine.string2Date(busJson.getString("actTime")));
                    bus.setCardId(busJson.getString("cardId"));
                    bus.setOrgName(busJson.getString("orgName"));
                    bus.setArriveDest(busJson.getBoolean("isArriveDest"));
                    bus.setDualSerialNum(busJson.getInt("dualSerialNum"));
                    buses.add(bus);
                }
            }
        }
        catch (JSONException e)
        {
            Log.d(sTAG, e.toString());
        }

        return buses;
    }

    public String getBusId() {
        return mBusId;
    }

    public void setBusId(String busId) {
        mBusId = busId;
    }

    public double getLng() {
        return mLng;
    }

    public void setLng(double lng) {
        mLng = lng;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        mLat = lat;
    }

    public double getVelocity() {
        return mVelocity;
    }

    public void setVelocity(double velocity) {
        mVelocity = velocity;
    }

    public String getIsArrvLft() {
        return mIsArrvLft;
    }

    public void setIsArrvLft(String isArrvLft) {
        mIsArrvLft = isArrvLft;
    }

    public int getStationSeqNum() {
        return mStationSeqNum;
    }

    public void setStationSeqNum(int stationSeqNum) {
        mStationSeqNum = stationSeqNum;
    }

    public String getBuslineId() {
        return mBuslineId;
    }

    public void setBuslineId(String buslineId) {
        mBuslineId = buslineId;
    }

    public String getCardId() {
        return mCardId;
    }

    public void setCardId(String cardId) {
        mCardId = cardId;
    }

    public String getOrgName() {
        return mOrgName;
    }

    public void setOrgName(String orgName) {
        mOrgName = orgName;
    }

    public int getDualSerialNum() {
        return mDualSerialNum;
    }

    public void setDualSerialNum(int dualSerialNum) {
        mDualSerialNum = dualSerialNum;
    }

    public boolean isArriveDest() {
        return mIsArriveDest;
    }

    public void setArriveDest(boolean isArriveDest) {
        mIsArriveDest = isArriveDest;
    }

    public Date getActTime() {
        return mActTime;
    }

    public void setActTime(Date actTime) {
        mActTime = actTime;
    }
}
