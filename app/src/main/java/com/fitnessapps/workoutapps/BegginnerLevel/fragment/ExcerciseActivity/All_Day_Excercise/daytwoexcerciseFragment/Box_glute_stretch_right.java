package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.all_day_excercise_class.Day_two_box_glute_stretch_right_class;
import com.fitnessapps.workoutapps.R;

public class Box_glute_stretch_right extends Fragment {

    View right;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_box_glute_stretch_right, container, false);

        right=view.findViewById(R.id.box_glute_stretch_right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_two_box_glute_stretch_right_class day_two_box_glute_stretch_right_class=new Day_two_box_glute_stretch_right_class();
                day_two_box_glute_stretch_right_class.show(getFragmentManager(),"box stretch right");
            }
        });

        return view;
    }
}