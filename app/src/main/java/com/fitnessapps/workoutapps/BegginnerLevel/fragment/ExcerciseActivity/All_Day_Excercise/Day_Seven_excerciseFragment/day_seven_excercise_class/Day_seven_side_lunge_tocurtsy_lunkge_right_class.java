package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Seven_excerciseFragment.day_seven_excercise_class;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.fitnessapps.workoutapps.R;

public class Day_seven_side_lunge_tocurtsy_lunkge_right_class extends DialogFragment {
    TextView camalfinish;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.day_seven_side_lunge_to_curtsy_lankgeright_layout,container,false);
        camalfinish=view.findViewById(R.id.sidelungetocurtsylunkgeright_finish);
        camalfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }
}
