package com.example.yuan.jinanbus;

import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


@SuppressWarnings("ALL")
public class BuslineDeatilActivity
        extends ActionBarActivity
        implements ActionBar.TabListener {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public static final String sLineIdExtra = "com.example.yuan.LINE_ID";
    public static final String sBusLineDetail = "com.example.yuan.LINE_DETAIL";
    public static String sTAG = "BusLineDetailActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busline_deatil);

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        /*
      The {@link android.support.v4.view.PagerAdapter} that will provide
      fragments for each of the sections. We use a
      {@link FragmentPagerAdapter} derivative, which will keep every
      loaded fragment in memory. If this becomes too memory intensive, it
      may be best to switch to a
      {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),
                getIntent().getStringExtra(sLineIdExtra),
                getIntent().getStringExtra(sBusLineDetail));

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(sectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < sectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(sectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_busline_deatil, menu);
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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final int iLineDetailSection = 0;
        private final int iBusesDetailSection = 1;
        private final int iStationsSection = 2;
        private final int iSectionSum = 3;
        private final String mBusLine;
        private String mBusId = "";

        public SectionsPagerAdapter(FragmentManager fm, String iBusId, String busLine) {
            super(fm);
            mBusId = iBusId;
            mBusLine = busLine;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Bundle args = new Bundle();
            args.putString(sLineIdExtra, mBusId);
            args.putString(sBusLineDetail, mBusLine);
            switch (position) {
                default:
                case iLineDetailSection:
                    BusLineFragment blf = new BusLineFragment();
                    blf.setArguments(args);
                    return blf;
                case iBusesDetailSection:
                    BusFragment bf = new BusFragment();
                    bf.setArguments(args);
                    return bf;
                //case iStationsSection:
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2; //暂时先只显示两个
            //return iSectionSum;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case iLineDetailSection:
                    return getString(R.string.title_section1).toUpperCase(l);
                case iBusesDetailSection:
                    return getString(R.string.title_section2).toUpperCase(l);
                case iStationsSection:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class BusLineFragment extends Fragment {
        private final String mLineInfoFormat = "线路名称：%1s\n" +
                "起始站：%2s\n" +
                "终点站：%3s\n" +
                "票价：%4s\n" +
                "运行时间：%5s\n" +
                "站列表：\n";

        private TextView mTextView;
        private BusLine mBusLine;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            mBusLine = BusLine.parse(getArguments().getString(sBusLineDetail));
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_busline_deatil, container, false);
            mTextView = (TextView)rootView.findViewById(R.id.textViewBusLineDetail);

            String sInfo = String.format(mLineInfoFormat, mBusLine.getLineName(),
                    mBusLine.getStartStationName(),
                    mBusLine.getEndStationName(),
                    mBusLine.getTicketPrice(),
                    mBusLine.getOperationTime()
            );
            for (BusLine.Station st : mBusLine.getStations()) {
                sInfo += st.getStationName();
                sInfo += "\n";
            }

            mTextView.setText(sInfo);

            return rootView;
        }

    }

}
