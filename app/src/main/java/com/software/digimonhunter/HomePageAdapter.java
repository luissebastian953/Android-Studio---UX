package com.software.digimonhunter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class HomePageAdapter extends FragmentStatePagerAdapter {

    String titleTab[] = {"Bronze", "Silver", "Gold"};
    private int tabCount;
    public HomePageAdapter(FragmentManager fragmentManager, int tabCount){
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titleTab[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new BronzeFragment();
                break;
            case 1:
                fragment = new SilverFragment();
                break;
            case 2:
                fragment = new GoldFragment();
                break;
            default:
                fragment = new BronzeFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
