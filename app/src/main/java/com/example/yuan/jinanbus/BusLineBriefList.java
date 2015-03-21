package com.example.yuan.jinanbus;

import android.content.Context;

import java.util.ArrayList;

/**
 * 存储查询到的BusLine
 * Created by Yuan on 2015/3/17.
 */
public class BusLineBriefList {
    private ArrayList<BusLineBrief> mBusLineBrief;
    private Context mAppContext;


    private static BusLineBriefList sBusLineBriefList;

    public static BusLineBriefList get(Context c) {
        if (sBusLineBriefList == null) {
            sBusLineBriefList = new BusLineBriefList(c.getApplicationContext());
        }
        return sBusLineBriefList;
    }

    private BusLineBriefList(Context c) {
        mAppContext = c;
        mBusLineBrief = new ArrayList<>();
    }

    public void add(BusLineBrief bl) {
        mBusLineBrief.add(bl);
    }

    public void clear() {
        mBusLineBrief.clear();
    }

    public void add(ArrayList<BusLineBrief> arrayBusses) {
        mBusLineBrief.addAll(arrayBusses);
    }

    public ArrayList<BusLineBrief> getBusLines() {
        return mBusLineBrief;
    }

    public BusLineBrief get(int position){
        if (position >= 0 && position < mBusLineBrief.size()) {
            return mBusLineBrief.get(position);
        }
        return null;
    }
    public BusLineBrief get(String id) {
        for (BusLineBrief bl : mBusLineBrief) {
            if (bl.getId().equals(id)) {
                return bl;
            }
        }
        return null;
    }
}

