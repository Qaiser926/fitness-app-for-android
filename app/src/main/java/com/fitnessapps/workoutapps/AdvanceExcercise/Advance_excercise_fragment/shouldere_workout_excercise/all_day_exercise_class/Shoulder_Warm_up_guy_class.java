package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.all_day_exercise_class;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.fitnessapps.workoutapps.R;

public class Shoulder_Warm_up_guy_class extends DialogFragment {
    TextView close;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.advance_shoulder_warm_up_guy_layout,container,false);
       close=view.findViewById(R.id.shoulder_warmuppguy_finish
       );
       close.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dismiss();
           }
       });
       return view;
    }
}
