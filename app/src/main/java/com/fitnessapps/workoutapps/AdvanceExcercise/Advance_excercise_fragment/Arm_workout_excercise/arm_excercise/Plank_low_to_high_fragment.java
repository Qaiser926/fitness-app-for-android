package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Arm_workout_excercise.arm_excercise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Arm_workout_excercise.arm_all_day_clas.Arm_plank_lowto_high_class;
import com.fitnessapps.workoutapps.R;

public class Plank_low_to_high_fragment extends Fragment {

View brige;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_plank_low_to_high_fragment, container, false);
        brige=view.findViewById(R.id.armplanklowtohigh);
        brige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arm_plank_lowto_high_class chest_workout_brige_class=new Arm_plank_lowto_high_class();
                chest_workout_brige_class.show(getFragmentManager(),"brige");
            }
        });
        return view;}
}