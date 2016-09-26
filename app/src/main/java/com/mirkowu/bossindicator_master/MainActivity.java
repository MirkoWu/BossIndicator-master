package com.mirkowu.bossindicator_master;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mirkowu.bossindicator.BossIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BossIndicator mIndicator;
    private ViewPager mViewPager;

    private FragmentPagerAdapter mAdapter;
    private List<String> mDatas;
    private List<Fragment> mTabContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIndicator= (BossIndicator) findViewById(R.id.indicator);
        mViewPager= (ViewPager) findViewById(R.id.viewpager);
        initView();
    }

    private void initView() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.home_tabs));
        mTabContents = new ArrayList<>();
        mTabContents.add(new MainFragment());
        mTabContents.add(new MainFragment());
        mTabContents.add(new MainFragment());
        mTabContents.add(new MainFragment());

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTabContents.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }
        };

        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mIndicator.setViewPager(mViewPager, 0);

    }

}
