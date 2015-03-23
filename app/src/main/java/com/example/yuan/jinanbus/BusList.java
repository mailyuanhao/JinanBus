package com.example.yuan.jinanbus;

import java.util.ArrayList;

/**用于存储当前查询公交线路的公交车
 * Created by Yuan on 2015/3/22.
 */
class BusList {
    private final ArrayList<Bus> mBuses = new ArrayList<>();

    public void insertBus(Bus b) {
        mBuses.add(b);
    }

    public ArrayList<Bus> getBuses() {
        return mBuses;
    }

    public Bus findBus(int iPosition){
        Bus b = null;
        if (iPosition >= 0 && iPosition < mBuses.size()) {
           b = mBuses.get(iPosition);
        }
        return b;

    }
}
