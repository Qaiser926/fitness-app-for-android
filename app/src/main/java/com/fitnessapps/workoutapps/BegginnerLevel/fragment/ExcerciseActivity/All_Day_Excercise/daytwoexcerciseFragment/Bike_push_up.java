package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.all_day_excercise_class.Day_two_bike_push_up_class;
import com.fitnessapps.workoutapps.R;

public class Bike_push_up extends Fragment {
    View bikepushup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bike_push_up, container, false);
        bikepushup=view.findViewById(R.id.day_two_bikepushup);
        bikepushup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_two_bike_push_up_class day_two_bike_push_up_class=new Day_two_bike_push_up_class();
                day_two_bike_push_up_class.show(getFragmentManager(),"bike push up");
            }
        });
    return view;
    }
}