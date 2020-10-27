package com.software.digimonhunter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.software.digimonhunter.user.Back;
import com.software.digimonhunter.user.UserModel;
import com.software.digimonhunter.user.UserSharedPref;

import java.util.Objects;

public class HomeActivity extends Fragment {

    RelativeLayout HomeLayout;
    TextView userTextView;
    TabLayout tabLayout;
    ViewPager viewPager;
    HomePageAdapter homePageAdapter;
    TabItem tabBronze, tabSilver, tabGold;
    TextView marquee;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View inflaterView = inflater.inflate(R.layout.activity_home, container, false);
        tabLayout = inflaterView.findViewById(R.id.tab_home_layout);
        tabBronze = inflaterView.findViewById(R.id.tab_bronze);
        tabSilver = inflaterView.findViewById(R.id.tab_silver);
        tabGold = inflaterView.findViewById(R.id.tab_gold);
        userTextView = inflaterView.findViewById(R.id.tv_user);
        HomeLayout = (RelativeLayout) inflaterView.findViewById(R.id.rl_home_layout);
        marquee = inflaterView.findViewById(R.id.tv_membership);
        marquee.setSelected(true);

        viewPager = (ViewPager) inflaterView.findViewById(R.id.vw_pager);
        homePageAdapter = new HomePageAdapter(getActivity().getSupportFragmentManager() , tabLayout.getTabCount());
        viewPager.setAdapter(homePageAdapter);
        HomeLayout.setBackgroundResource(R.drawable.gradient_bronze);
//        viewPager.setOffscreenPageLimit(3);
//        viewPager.setCurrentItem(0);

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        UserSharedPref userSharedPref = new UserSharedPref(getActivity());
        UserModel userModel = userSharedPref.loggedUser();
        String welcomer = "Welcome, "+userModel.getUsername();
        Back back = new Back();
        back.setBack("notBack");
        userSharedPref.setBackDetail(back);
        userTextView.setText(welcomer);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 1){
                    viewPager.setCurrentItem(1);
                    HomeLayout.setBackgroundResource(R.drawable.gradient_silver);
                }else if(tab.getPosition() == 2){
                    viewPager.setCurrentItem(2);
                    HomeLayout.setBackgroundResource(R.drawable.gradient_gold);
                }else{
                    viewPager.setCurrentItem(0);
                    HomeLayout.setBackgroundResource(R.drawable.gradient_bronze);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        return inflaterView;
    }
}
