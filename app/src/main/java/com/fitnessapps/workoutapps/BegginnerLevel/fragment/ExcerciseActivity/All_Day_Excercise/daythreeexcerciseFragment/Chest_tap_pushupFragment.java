package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daythreeexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daythreeexcerciseFragment.day_three_excercise_class.Day_three_chest_tap_pushup_class;
import com.fitnessapps.workoutapps.R;

public class Chest_tap_pushupFragment extends Fragment {
View camal;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_chest_tap_pushup, container, false);
        camal=view.findViewById(R.id.chesttappushup);
        camal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_three_chest_tap_pushup_class camal_pose_class=new Day_three_chest_tap_pushup_class();
                camal_pose_class.show(getFragmentManager(),"camal");
            }
        });
        return view;
    }
}