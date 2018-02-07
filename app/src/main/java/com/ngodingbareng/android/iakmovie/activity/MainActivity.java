package com.ngodingbareng.android.iakmovie.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

import com.ngodingbareng.android.iakmovie.R;
import com.ngodingbareng.android.iakmovie.adapter.TabFragmentPagerAdapter;

/**
 * Created by dell on 1/30/18.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setup toolbar
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle("IAK Movie");

        //inisialisaasi tab dan pager
        ViewPager pager = findViewById(R.id.pager);
        TabLayout tabs = findViewById(R.id.tabs);

        //set object adapter
        pager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));

        //manipulasi textcolor tabs
        tabs.setTabTextColors(getResources().getColor(R.color.colorWhite),getResources().getColor(android.R.color.white));

        //set tab ke view pager
        tabs.setupWithViewPager(pager);

        //konfig gravity fill
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

    }
}
