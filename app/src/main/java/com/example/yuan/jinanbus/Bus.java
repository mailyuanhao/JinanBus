package com.example.yuan.jinanbus;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * 代表单独的一辆Bus
 * Created by Yuan on 2015/3/15.
 */
@SuppressWarnings("FieldCanBeLocal")
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
    //指向自己的线路列表
    private BusLine mBusLine;

    private static final String sTAG = "Bus";

    public static ArrayList<Bus> parse(String jsonString) {
        ArrayList<Bus> buses = new ArrayList<>();
        try {
            JSONObject busesJson = new JSONObject(jsonString);
            int status = busesJson.getJSONObject("status").getInt("code");
            if (status == 0) {
                JSONArray busJsonArray = busesJson.getJSONArray("result");
                for (int i = 0; i < busJsonArray.length(); i++) {
                    JSONObject busJson = busJsonArray.getJSONObject(i);
                    Bus bus = parseOneBus(busJson);
                    buses.add(bus);
                }
            }
        } catch (JSONException e) {
            Log.d(sTAG, e.toString());
        }

        return buses;
    }

    private static Bus parseOneBus(JSONObject busJson) throws JSONException {
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
        return bus;
    }

    public String getBusId() {
        return mBusId;
    }

    void setBusId(String busId) {
        mBusId = busId;
    }

    public double getLng() {
        return mLng;
    }

    void setLng(double lng) {
        mLng = lng;
    }

    void setLat(double lat) {
        mLat = lat;
    }

    public double getVelocity() {
        return mVelocity;
    }

    void setVelocity(double velocity) {
        mVelocity = velocity;
    }

    public String getIsArrvLft() {
        return mIsArrvLft;
    }

    void setIsArrvLft(String isArrvLft) {
        mIsArrvLft = isArrvLft;
    }

    int getStationSeqNum() {
        return mStationSeqNum;
    }

    void setStationSeqNum(int stationSeqNum) {
        mStationSeqNum = stationSeqNum;
    }

    public String getBuslineId() {
        return mBuslineId;
    }

    void setBuslineId(String buslineId) {
        mBuslineId = buslineId;
    }

    public String getCardId() {
        return mCardId;
    }

    void setCardId(String cardId) {
        mCardId = cardId;
    }

    public String getOrgName() {
        return mOrgName;
    }

    void setOrgName(String orgName) {
        mOrgName = orgName;
    }

    public int getDualSerialNum() {
        return mDualSerialNum;
    }

    void setDualSerialNum(int dualSerialNum) {
        mDualSerialNum = dualSerialNum;
    }

    public boolean isArriveDest() {
        return mIsArriveDest;
    }

    void setArriveDest(boolean isArriveDest) {
        mIsArriveDest = isArriveDest;
    }

    public Date getActTime() {
        return mActTime;
    }

    void setActTime(Date actTime) {
        mActTime = actTime;
    }

    private String getStationName(){
        int i = getStationSeqNum();
        if (mBusLine != null) {
            if (i >= 0 && i < mBusLine.getStations().size()) {
                return mBusLine.getStations().get(i).getStationName();
            }
        }
        return String.valueOf(i);
    }

    public String toString() {
        String f = "ID：%1s, 即将到达：%2s";
        return String.format(f, getBusId(), getStationName());
    }

    public BusLine getBusLine() {
        return mBusLine;
    }

    public void setBusLine(BusLine busLine) {
        mBusLine = busLine;
    }

    public static class SortByStation implements Comparator {
        @Override
        public int compare(Object lhs, Object rhs) {
            Bus l = (Bus)lhs;
            Bus r = (Bus)rhs;
            return l.getStationSeqNum() - r.getStationSeqNum();
        }
    }
}
