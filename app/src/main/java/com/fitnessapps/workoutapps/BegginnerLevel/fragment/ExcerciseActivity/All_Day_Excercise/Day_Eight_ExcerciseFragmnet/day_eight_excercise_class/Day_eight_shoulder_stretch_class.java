package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet.day_eight_excercise_class;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.fitnessapps.workoutapps.R;

public class Day_eight_shoulder_stretch_class extends DialogFragment {
    TextView chest;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.day_eight_shoulder_stretch_layout,container,false);
        chest=view.findViewById(R.id.shoulderstretch_finish);
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }
}
