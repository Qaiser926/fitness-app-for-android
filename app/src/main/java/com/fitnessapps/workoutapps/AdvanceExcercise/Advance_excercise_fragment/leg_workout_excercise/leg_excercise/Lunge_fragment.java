package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_all_exercise_class.Leg_lunge_clas;
import com.fitnessapps.workoutapps.R;

public class Lunge_fragment extends Fragment {
View legflutter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lunge_fragment, container, false);

        legflutter=view.findViewById(R.id.lunge);
        legflutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leg_lunge_clas leg_boat_hol_leg_flutter_class=new Leg_lunge_clas();
                leg_boat_hol_leg_flutter_class.show(getFragmentManager(),"leg flutter");
            }
        });
        return view;}
}