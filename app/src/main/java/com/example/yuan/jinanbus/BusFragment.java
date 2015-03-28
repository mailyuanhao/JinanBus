package com.example.yuan.jinanbus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class BusFragment extends Fragment {

    private String mBusId;
    private ArrayAdapter<Bus> mBusArrayAdapter;
    private BusList mBusList;
    private BusLine mBusLine;
    public BusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBusId = getArguments().getString(BuslineDeatilActivity.sLineIdExtra);
            mBusLine = BusLine.parse(getArguments().getString(BuslineDeatilActivity.sBusLineDetail));
        }

        mBusList = new BusList();

        mBusArrayAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                mBusList.getBuses());


        startRefreshBusInfo();

    }

    private void startRefreshBusInfo() {
        new QueryBuses().execute(MakeUrlString.makeBusDetailURL(mBusId));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bus, container, false);
        final ListView lv = (ListView) rootView.findViewById(R.id.busListView);
        lv.setAdapter(mBusArrayAdapter);

        return rootView;
    }


    private class QueryBuses extends QueryTask {

        private final int mDelay = 10 * 1000;
        android.os.Handler mHandler = new android.os.Handler();
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                startRefreshBusInfo();
            }
        };

        @Override
        protected void onPostExecute(String s) {
            try {
                ArrayList<Bus> alb = Bus.parse(s);
                if (!alb.isEmpty()) {
                    mBusList.clear();
                    refreshBusList(alb);
                }
            }
            finally {
                mHandler.postDelayed(mRunnable, mDelay);
                mBusArrayAdapter.notifyDataSetChanged();
            }
        }

        private void refreshBusList(ArrayList<Bus> alb) {
            for (Bus b : alb) {
                b.setBusLine(mBusLine);
                mBusList.insertBus(b);
            }
            mBusList.sort();
        }
    }
}
