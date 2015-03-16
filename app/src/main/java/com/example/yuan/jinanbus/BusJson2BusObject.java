package com.example.yuan.jinanbus;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 分析Bus的json字符串
 * Created by Yuan on 2015/3/15.
 */
class BusJson2BusObject {
    private static String sTAG = "BusJson2BusObject";

    private String mBusJsonString;
    public BusJson2BusObject(String busJson) {
        mBusJsonString = busJson;
    }

    public ArrayList<Bus> parse() {
        ArrayList<Bus> buses = new ArrayList<>();
        try {
            JSONObject busesJson = new JSONObject(mBusJsonString);
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
                    bus.setActTime(busJson.getString("actTime"));
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
}
