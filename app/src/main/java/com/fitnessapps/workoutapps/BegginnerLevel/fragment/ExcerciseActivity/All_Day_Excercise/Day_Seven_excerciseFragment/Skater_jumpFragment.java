package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Seven_excerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Seven_excerciseFragment.day_seven_excercise_class.Day_seven_skater_jump_class;
import com.fitnessapps.workoutapps.R;

public class Skater_jumpFragment extends Fragment {
View curtsy;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_skater_jump, container, false);
        curtsy=view.findViewById(R.id.skaterjump);
        curtsy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_seven_skater_jump_class day_seven_side_lungeto_curtsy_lunkge_left_class=new Day_seven_skater_jump_class();
                day_seven_side_lungeto_curtsy_lunkge_left_class.show(getFragmentManager(),"curtsy");
            }
        });
        return view;
    }
}