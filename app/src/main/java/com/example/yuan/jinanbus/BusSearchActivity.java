package com.example.yuan.jinanbus;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.yuan.jinanbus.GetHttpJson.getURLContentString;
import static com.example.yuan.jinanbus.MakeUrlString.makeBusLineBriefURL;
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
        private ArrayAdapter<BusLineBrief> mAdapter;
        private ListView mBuslineList;
        private EditText mBusLineBriefEditText;
        private Button mQueryBusLine;

        public PlaceholderFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            mBusLineBriefs = BusLineBriefList.get(getActivity()).getBusLines();
            mAdapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1,
                    mBusLineBriefs);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_bus_search, container, false);

            mBuslineList = (ListView) rootView.findViewById(R.id.buslines_list);
            mBuslineList.setAdapter(mAdapter);
            mBuslineList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    BusLineBrief blb = BusLineBriefList.get(getActivity()).get(position);
                    Intent i = new Intent(getActivity(), BuslineDeatilActivity.class);
                    i.putExtra(BuslineDeatilActivity.sLineIdExtra, blb.getId());
                    startActivity(i);
                }
            });

            mBusLineBriefEditText = (EditText) rootView.findViewById(R.id.bus_line_text_view);
            mBusLineBriefEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    setQueryButtonEnabled(s.toString());
                }
            });

            mQueryBusLine = (Button) rootView.findViewById(R.id.query_bus_line);
            setQueryButtonEnabled(mBusLineBriefEditText.getText().toString());
            mQueryBusLine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BusLineBriefList.get(getActivity()).clear();
                    String s = mBusLineBriefEditText.getText().toString();
                    if (s != null && s.length() > 0) {
                        new QueryBusLineBrief().execute(s);
                    }
                }
            });

            Button testButton = (Button) rootView.findViewById(R.id.test_button);
            testButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(sTAG, "onClick");
                    testBusJson2BusObject();
                    testBusLineParse();
                    testBusLineBriefParse();
                }
            });
            testButton.setVisibility(View.INVISIBLE);

            return rootView;
        }

        private void setQueryButtonEnabled(String sContent) {
            if (sContent == null || sContent.isEmpty()) {
                mQueryBusLine.setEnabled(false);
            } else {
                mQueryBusLine.setEnabled(true);
            }
        }

        class QueryBusLineBrief extends QueryTask {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mQueryBusLine.setEnabled(false);
            }

            @Override
            protected void onPostExecute(String s) {
                if (s != null) {
                    Log.d(sTAG, s);
                    BusLineBriefList.get(getActivity()).add(BusLineBrief.parse(s));
                    if (BusLineBriefList.get(getActivity()).getBusLines().isEmpty()) {
                        showToastInfo(R.string.bus_line_not_exist);
                    }
                    mAdapter.notifyDataSetChanged();
                } else {
                    showToastInfo(R.string.query_failed);
                }
                mQueryBusLine.setEnabled(true);
            }
        }

        private void showToastInfo(int id) {
            Toast.makeText(getActivity(),
                    id,
                    Toast.LENGTH_SHORT).show();
        }
    }

}
