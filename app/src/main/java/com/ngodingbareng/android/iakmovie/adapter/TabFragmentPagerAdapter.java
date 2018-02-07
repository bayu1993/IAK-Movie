package com.ngodingbareng.android.iakmovie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ngodingbareng.android.iakmovie.fragment.HomeFragment;
import com.ngodingbareng.android.iakmovie.fragment.NewMovieFragment;
import com.ngodingbareng.android.iakmovie.fragment.TopRateFragment;

/**
 * Created by dell on 2/5/18.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    //nama tab
    private String[] namaTab = new String[]{
            "Home","Teratas", "Terbaru"
    };
    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new TopRateFragment();
                break;
            case 2:
                fragment = new NewMovieFragment();
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return namaTab.length;
    }
    @Override
    public CharSequence getPageTitle(int position){
        return namaTab[position];
    }
}
