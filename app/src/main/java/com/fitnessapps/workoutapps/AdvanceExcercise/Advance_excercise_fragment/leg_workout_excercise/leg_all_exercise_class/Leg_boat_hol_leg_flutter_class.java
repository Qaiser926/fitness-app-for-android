package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_all_exercise_class;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.fitnessapps.workoutapps.R;

public class Leg_boat_hol_leg_flutter_class extends DialogFragment {
    TextView close;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.advance_leg_boat_hol_leg_flutter_layout,container,false);
       close=view.findViewById(R.id.boathollegflutter_finish
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
