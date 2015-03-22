package com.example.yuan.jinanbus;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BusFragment extends Fragment {

    private String mBusId;
    private ArrayAdapter<Bus> mBusArrayAdapter;
    private BusList mBusList;
    public BusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBusId = getArguments().getString(BuslineDeatilActivity.sLineIdExtra);
        }

        mBusList = new BusList();

        mBusArrayAdapter = new ArrayAdapter<Bus>(getActivity(),
                android.R.layout.simple_list_item_1,
                mBusList.getBuses());


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
        @Override
        protected void onPostExecute(String s) {
            ArrayList<Bus> alb = Bus.parse(s);
            for (Bus b : alb) {
                mBusList.insertBus(b);
            }

            mBusArrayAdapter.notifyDataSetChanged();
        }
    }
}
