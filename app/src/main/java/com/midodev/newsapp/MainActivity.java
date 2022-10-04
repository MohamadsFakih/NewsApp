package com.midodev.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome,mhealth,mtech,mentertainment,msports;
    PageAdapter pageAdapter;
    Toolbar mtoolbar;
    String api ="7eb2565c22a243489c8c84a4568cc540";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome=findViewById(R.id.home);
        mhealth=findViewById(R.id.health);
        msports=findViewById(R.id.sports);
        mtech=findViewById(R.id.tech);
        mentertainment=findViewById(R.id.enter);
        ViewPager viewPager=findViewById(R.id.fragmentContainer);
        tabLayout=findViewById(R.id.include);

        pageAdapter=new PageAdapter(getSupportFragmentManager(),5);
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||
                tab.getPosition()==3||tab.getPosition()==4){
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}
