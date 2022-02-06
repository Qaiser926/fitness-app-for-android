package com.fitnessapps.workoutapps.BegginnerLevel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_fragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.Excercise_fragment;

public class ViewpagerAdapter extends FragmentPagerAdapter{
    int tabcount;
    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // ye usi number of fragment ko waha par beje ga jo selected he k konsa jaye ga ye yaha par decide ho ga.
        switch (position){
            // pageadapter ye map kare k konsa fragment show ho jaye
            case 0:return new Excercise_fragment();
            case 1:return new diet_fragment();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        // yaha par return zarori he agr hum return na kare ga k kitne tab he wanran tab display nhe ho ga.
        return tabcount;
    }
}
