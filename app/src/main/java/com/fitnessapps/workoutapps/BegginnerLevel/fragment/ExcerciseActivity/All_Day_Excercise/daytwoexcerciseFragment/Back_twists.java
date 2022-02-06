package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.all_day_excercise_class.Day_two_back_twist_class;
import com.fitnessapps.workoutapps.R;

public class Back_twists extends Fragment {
View dayone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_back_twists, container, false);

        dayone = view.findViewById(R.id.day_two_back_twist);
        dayone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_two_back_twist_class dayoneAbdomial_class = new Day_two_back_twist_class();
                dayoneAbdomial_class.show(getFragmentManager(), "My Fragment");
            }
        });
    return view;
    }
}