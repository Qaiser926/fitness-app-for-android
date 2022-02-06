package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daythreeexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daythreeexcerciseFragment.day_three_excercise_class.Camal_pose_class;
import com.fitnessapps.workoutapps.R;

public class Camal_pose_Fragment extends Fragment {
View camal;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_camal_pose_, container, false);
        camal=view.findViewById(R.id.camalpose);
        camal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Camal_pose_class camal_pose_class=new Camal_pose_class();
                camal_pose_class.show(getFragmentManager(),"camal");
            }
        });
        return view;
    }
}