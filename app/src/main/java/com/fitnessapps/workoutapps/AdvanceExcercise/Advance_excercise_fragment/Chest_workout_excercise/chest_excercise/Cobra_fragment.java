package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Chest_workout_excercise.chest_excercise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Chest_workout_excercise.chest_all_exercise_class.Chest_workout_cobra_class;
import com.fitnessapps.workoutapps.R;

public class Cobra_fragment extends Fragment {
View brige;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cobra_fragment, container, false);
        brige=view.findViewById(R.id.advancecobra);
        brige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chest_workout_cobra_class chest_workout_brige_class=new Chest_workout_cobra_class();
                chest_workout_brige_class.show(getFragmentManager(),"brige");
            }
        });
        return view;
    }
}