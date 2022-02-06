package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_all_exercise_class.Leg_jumping_jack_class;
import com.fitnessapps.workoutapps.R;

public class Jumping_secod_jack_fragment extends Fragment {
View legflutter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_jumping_jack_fragment2, container, false);
        legflutter=view.findViewById(R.id.advancejumpingjack);
        legflutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leg_jumping_jack_class leg_boat_hol_leg_flutter_class=new Leg_jumping_jack_class();
                leg_boat_hol_leg_flutter_class.show(getFragmentManager(),"leg flutter");
            }
        });
        return view;}
}