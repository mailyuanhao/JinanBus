package com.example.yuan.jinanbus;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.yuan.jinanbus.YhTest.*;

public class BusSearchActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_search);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bus_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private static String sTAG = "PlaceholderFragment";
        private ArrayList<BusLineBrief> mBusLineBriefs;
        private ArrayAdapter<BusLineBrief> adapter;
        private ListView buslineList;
        public PlaceholderFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            mBusLineBriefs = BusLineBriefList.get(getActivity()).getBusLines();
            adapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1,
                    mBusLineBriefs);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_bus_search, container, false);

            buslineList = (ListView)rootView.findViewById(R.id.buslines_list);
            buslineList.setAdapter(adapter);

            Button queryBusLine = (Button)rootView.findViewById(R.id.query_bus_line);
            queryBusLine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BusLineBriefList.get(getActivity()).add(testBusLineBriefParse());
                    adapter.notifyDataSetChanged();
                }
            });

            Button testButton = (Button)rootView.findViewById(R.id.test_button);
            testButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(sTAG, "onClick");
                    testBusJson2BusObject();
                    testBusLineParse();
                    testBusLineBriefParse();
                }
            });

            return rootView;
        }

        class QueryBusLineBrief extends AsyncTask<String, Integer, Long> {
            @Override
            protected Long doInBackground(String... params) {

                return new Long(0);
            }
        }
    }

}
