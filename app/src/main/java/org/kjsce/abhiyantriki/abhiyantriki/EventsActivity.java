package org.kjsce.abhiyantriki.abhiyantriki;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class EventsActivity extends NavActivity {
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private AdapterFragmentEvent mfragmentEvent;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout=(FrameLayout) findViewById(R.id.frame);

        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View activityView=inflater.inflate(R.layout.activity_events,null,false);

        frameLayout.addView(activityView);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Events");
        // Create the adapter that will return a fragment for each of the five
        // primary sections of the activity.
        mfragmentEvent = new AdapterFragmentEvent(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mfragmentEvent);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(mViewPager);
    }
}

