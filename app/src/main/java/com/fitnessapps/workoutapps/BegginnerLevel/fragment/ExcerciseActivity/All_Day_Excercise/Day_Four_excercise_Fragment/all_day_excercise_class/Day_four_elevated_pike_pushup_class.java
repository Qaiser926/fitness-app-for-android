package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Four_excercise_Fragment.all_day_excercise_class;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.fitnessapps.workoutapps.R;

public class Day_four_elevated_pike_pushup_class extends DialogFragment {
    TextView txtclose;
    Button nextbtn;
    Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view= inflater.inflate(R.layout.day_four_elevated_pike_pushup_layout,container,false);

        // ab yaha par jo feature me add karna chahta ho o yaha par add karo ga.
        txtclose=view.findViewById(R.id.elevatedpikepushup_finish);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    return view;
    }

}
