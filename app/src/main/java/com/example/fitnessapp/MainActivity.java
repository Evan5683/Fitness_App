package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager2 viewPager;
    private LinearLayout llHome, llStatistics, llCourse, llFeed, llProfile;
    private ImageView ivHome, ivStatistics, ivCourse, ivFeed, ivProfile, ivCorrunt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();
    }
    private void initTabView(){
        llHome = findViewById(R.id.id_tab_home);
        llHome.setOnClickListener(this);
        llStatistics = findViewById(R.id.id_tab_Statistics);
        llStatistics.setOnClickListener(this);
        llCourse = findViewById(R.id.id_tab_Courses);
        llCourse.setOnClickListener(this);
        llFeed = findViewById(R.id.id_tab_Feed);
        llFeed.setOnClickListener(this);
        llProfile = findViewById(R.id.id_tab_profile);
        llProfile.setOnClickListener(this);
        ivHome = findViewById(R.id.tab_iv_home);
        ivStatistics = findViewById(R.id.tab_iv_Statistics);
        ivCourse = findViewById(R.id.tab_iv_Courses);
        ivFeed = findViewById(R.id.tab_iv_Feed);
        ivProfile = findViewById(R.id.tab_iv_Profile);

        ivHome.setSelected(true);


    }

    private void initPager(){
        viewPager = findViewById(R.id.id_viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance(""));
        fragments.add(BlankFragment.newInstance(""));
        fragments.add(BlankFragment.newInstance(""));
        fragments.add(BlankFragment.newInstance(""));
        fragments.add(BlankFragment.newInstance(""));
        MyfragmentPagerAdapter

    }
}