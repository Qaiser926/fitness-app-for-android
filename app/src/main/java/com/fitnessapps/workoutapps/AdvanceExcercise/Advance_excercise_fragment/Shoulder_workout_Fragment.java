package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Main_shoulder_workout_excercise;
import com.fitnessapps.workoutapps.R;

public class Shoulder_workout_Fragment extends Fragment {
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_shoulder_workout_, container, false);
        imageView=view.findViewById(R.id.shoulderbtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Main_shoulder_workout_excercise.class);
                startActivity(intent);
            }
        });

    return view;
    }
}