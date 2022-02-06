package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet.day_eight_excercise_class.Day_eight_flutter_kick_class;
import com.fitnessapps.workoutapps.R;

public class Flutter_kick_second_Fragment extends Fragment {
    View bikepushup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_flutter_kick2, container, false);
        bikepushup=view.findViewById(R.id.dayeight_flutterkick);
        bikepushup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_eight_flutter_kick_class day_eight_bike_pushup_class=new Day_eight_flutter_kick_class();
                day_eight_bike_pushup_class.show(getFragmentManager(),"bike pushup");
            }
        });
        return view;
    }
}