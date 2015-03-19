package com.example.yuan.jinanbus;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * 查询到线路列表的JSON解析结果，只包含简单信息
 * Created by Yuan on 2015/3/18.
 */
public class BusLineBrief {
    public static String sJsonExample = "{\"status\":{\"code\":0},\"result\":{\"pageParam\":{\"offset\":0,\"len\":20,\"totalNum\":2},\"result\":[{\"id\":\"41\",\"localLineId\":\"33692957\",\"endStationName\":\"营市街\",\"lineName\":\"K22\",\"startStationName\":\"公交营运中心\",\"updateTime\":\"Aug 12, 2014 8:08:57 AM\"},{\"id\":\"42\",\"localLineId\":\"33692958\",\"endStationName\":\"公交营运中心\",\"lineName\":\"K22\",\"startStationName\":\"营市街\",\"updateTime\":\"Aug 12, 2014 8:09:21 AM\"}]}}";
    private static String sTAG = "BusLineBrief";
    private String mId;
    private String mLocalLineId;
    private String mEndStationName;
    private String mLineName;
    private String mStartStationName;
    private Date mUpdateTime;

    public static ArrayList<BusLineBrief> parse(String json) {
        ArrayList<BusLineBrief> buslines = new ArrayList<>();
        try {
            JSONObject busLinesJson = new JSONObject(json);
            JSONArray busJsonArray = busLinesJson.getJSONObject("result").getJSONArray("result");
            for (int i = 0; i < busJsonArray.length(); i++) {
                JSONObject busJson = busJsonArray.getJSONObject(i);
                BusLineBrief bus = parseOneLine(busJson);
                buslines.add(bus);
            }
        } catch (JSONException e) {
            Log.d(sTAG, e.toString());
        }

        return buslines;
    }

    private static BusLineBrief parseOneLine(JSONObject busJson) throws JSONException {
        BusLineBrief bus = new BusLineBrief();
        bus.mId = busJson.getString("id");
        bus.mLocalLineId = busJson.getString("localLineId");
        bus.mEndStationName = busJson.getString("endStationName");
        bus.mLineName = busJson.getString("lineName");
        bus.mStartStationName = busJson.getString("startStationName");
        bus.mUpdateTime = BusLine.string2Date(busJson.getString("updateTime"));
        return bus;
    }

    public String getId() {
        return mId;
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

    public String getStartStationName() {
        return mStartStationName;
    }

    public Date getUpdateTime() {
        return mUpdateTime;
    }

    @Override
    public String toString() {
        return String.format("%1s路 %2s -> %3s", mLineName, mStartStationName, mEndStationName);
    }
}
