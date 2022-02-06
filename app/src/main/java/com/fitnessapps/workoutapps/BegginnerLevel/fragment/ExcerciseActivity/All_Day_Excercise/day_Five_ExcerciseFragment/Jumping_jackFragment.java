package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.day_Five_ExcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.day_Five_ExcerciseFragment.day_five_excercise_class.Day_five_jumping_jack_class;
import com.fitnessapps.workoutapps.R;


public class Jumping_jackFragment extends Fragment {
    View highstep;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_jumping_jack, container, false);

        highstep=view.findViewById(R.id.jumpingjack);
        highstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_five_jumping_jack_class day_five_high_steeping_class=new Day_five_jumping_jack_class();
                day_five_high_steeping_class.show(getFragmentManager(),"high steping");
            }
        });
        return view;
    }
}