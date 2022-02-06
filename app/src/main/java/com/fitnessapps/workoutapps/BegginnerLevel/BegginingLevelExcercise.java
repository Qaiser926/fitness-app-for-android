package com.fitnessapps.workoutapps.BegginnerLevel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.fitnessapps.workoutapps.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class BegginingLevelExcercise extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem excercisetab,diettab;
    ViewPager viewPager;
    ViewpagerAdapter viewpagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beggining_level_excercise);

        tabLayout=findViewById(R.id.tablayout);
        excercisetab=findViewById(R.id.tabone_excercise);
        diettab=findViewById(R.id.tabOne_diet);
        viewPager=findViewById(R.id.begginerviewpager);

        viewpagerAdapter=new ViewpagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(viewpagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition()==0 || tab.getPosition()==1)
                    viewpagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        // ye listner me ne swip k liye lika jab swip karo fragmnet ko tab change ho ga
    }
}