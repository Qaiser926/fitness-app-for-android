package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.day_Six_excercise_fragemnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.day_Six_excercise_fragemnt.day_six_excercise_class.Day_six_modified_burpee_class;
import com.fitnessapps.workoutapps.R;

public class Modified_burpeeFragment extends Fragment {
    View abductor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_modified_burpee, container, false);
        abductor=view.findViewById(R.id.modifiedburpee);
        abductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_six_modified_burpee_class day_six_laying_abductor_stretch_left_class=new Day_six_modified_burpee_class();
                day_six_laying_abductor_stretch_left_class.show(getFragmentManager(),"Abductor stretch left");
            }
        });
        return view;
    }
}