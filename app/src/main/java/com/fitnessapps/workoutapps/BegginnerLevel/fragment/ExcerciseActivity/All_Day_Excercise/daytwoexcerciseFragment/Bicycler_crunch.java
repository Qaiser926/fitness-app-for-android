package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.all_day_excercise_class.Day_two_bicycle_crunch_class;
import com.fitnessapps.workoutapps.R;

public class Bicycler_crunch extends Fragment {
View daytwobicycle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bicycler_crunch, container, false);

        daytwobicycle=view.findViewById(R.id.day_two_bicyclecrunch);
        daytwobicycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_two_bicycle_crunch_class day_two_bicycle_crunch_class=new Day_two_bicycle_crunch_class();
                day_two_bicycle_crunch_class.show(getFragmentManager(),"Bicycle Crunch");
            }
        });
    return view;
    }
}