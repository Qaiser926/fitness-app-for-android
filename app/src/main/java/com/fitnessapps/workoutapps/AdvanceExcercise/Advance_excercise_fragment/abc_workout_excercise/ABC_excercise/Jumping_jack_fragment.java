package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.abc_workout_excercise.ABC_excercise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.abc_workout_excercise.abc_all_day_class.Abc_jumping_jack_class;
import com.fitnessapps.workoutapps.R;
public class Jumping_jack_fragment extends Fragment {
View brige;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_jumping_jack_fragment3, container, false);
        brige=view.findViewById(R.id.abcjumpingjack);
        brige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Abc_jumping_jack_class chest_workout_brige_class=new Abc_jumping_jack_class();
                chest_workout_brige_class.show(getFragmentManager(),"brige");
            }
        });
        return view;}
}