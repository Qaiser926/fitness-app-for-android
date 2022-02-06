package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.all_excercise_classes.DayoneAbdomial_Class;
import com.fitnessapps.workoutapps.R;

public class AbdominalCrunches_Fragment extends Fragment {

    Dialog myDialog;
    View dayone;
    Dialog dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_abdominal_crunches_, container, false);

        dayone = view.findViewById(R.id.day_one_abdominalcrunches);
        dayone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DayoneAbdomial_Class dayoneAbdomial_class = new DayoneAbdomial_Class();
                dayoneAbdomial_class.show(getFragmentManager(), "My Fragment");
                // ye code me is liye lika k me sirf dialog show karta ho is code ka zarye .
                // baki jo funcationality me add karna chahta ho  o to me jo class me banaya he dialog k liye us me change kare ge.
            }
        });
        return view;
    }
}