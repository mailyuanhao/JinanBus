package com.example.yuan.jinanbus;


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
    private String mActTime;
    private String mCardId;
    private String mOrgName;
    private boolean mIsArriveDest;
    private int mDualSerialNum;

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

    public String getActTime() {
        return mActTime;
    }

    public void setActTime(String actTime) {
        mActTime = actTime;
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
}
