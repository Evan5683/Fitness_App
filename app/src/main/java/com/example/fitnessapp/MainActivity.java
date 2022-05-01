package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager2 viewPager;
    private LinearLayout llHome, llStatistics, llCourse, llFeed, llProfile;
    private ImageView ivHome, ivStatistics, ivCourse, ivFeed, ivProfile, ivCurrent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabView();
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
        ivCurrent = ivHome;


    }

    private void initPager(){
        viewPager = findViewById(R.id.view_Pager);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("Home"));
        fragments.add(BlankFragment.newInstance("Statistic"));
        fragments.add(BlankFragment.newInstance("Course"));
        fragments.add(BlankFragment.newInstance("Feed"));
        fragments.add(BlankFragment.newInstance("Profile"));
        MyFragmentPageAdapter pagerAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTable(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTable(int position) {
        ivCurrent.setSelected(false);
        switch (position){
            case R.id.id_tab_home:
                viewPager.setCurrentItem(0);
            case 0:
                ivHome.setSelected(true);
                ivCurrent = ivHome;
                break;
            case R.id.id_tab_Statistics:
                viewPager.setCurrentItem(1);
            case 1:
                ivStatistics.setSelected(true);
                ivCurrent = ivStatistics;
                break;
            case R.id.id_tab_Courses:
                viewPager.setCurrentItem(2);
            case 2:
                ivCourse.setSelected(true);
                ivCurrent = ivCourse;
                break;
            case R.id.id_tab_Feed:
                viewPager.setCurrentItem(3);
            case 3:
                ivFeed.setSelected(true);
                ivCurrent = ivFeed;
                break;
            case R.id.id_tab_profile:
                viewPager.setCurrentItem(4);
            case 4:
                ivProfile.setSelected(true);
                ivCurrent = ivProfile;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        changeTable(view.getId());

    }
}