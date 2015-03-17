package com.example.yuan.jinanbus;

import android.content.Context;

import java.util.ArrayList;

/**存储查询到的BusLine
 * Created by Yuan on 2015/3/17.
 */
public class BusLineList {
    private ArrayList<BusLine> mBusLines;
    private Context mAppContext;


    private static BusLineList sBusLineList;
    public static BusLineList get(Context c) {
        if (sBusLineList == null) {
            sBusLineList = new BusLineList(c);
        }
        return sBusLineList;
    }

    private BusLineList(Context c) {
        mAppContext = c;
        mBusLines = new ArrayList<>();
    }

    public void add(BusLine bl) {
        mBusLines.add(bl);
    }

    public BusLine get(String id) {
        for (BusLine bl : mBusLines) {
            if (bl.getId().equals(id))
            {
                return bl;
            }
        }
        return null;
    }
}

