package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.all_day_excercise_class.Day_two_baot_hold_leg_flutter_class;
import com.fitnessapps.workoutapps.R;

public class Boat_hold_leg_flutters extends Fragment {
View boat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_boat_hold_leg_flutters, container, false);
        boat=view.findViewById(R.id.day_two_baotholdleg_flutter);
        boat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_two_baot_hold_leg_flutter_class day_two_baot_hold_leg_flutter_class=new Day_two_baot_hold_leg_flutter_class();
                day_two_baot_hold_leg_flutter_class.show(getFragmentManager(),"Baot hold leg");
            }
        });
        return view;
    }
}