package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.all_excercise_classes.Day_one_cobra_stretch_class;
import com.fitnessapps.workoutapps.R;

public class CobraStretch_Fragment extends Fragment {

View dayone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cobra_stretch_, container, false);

        dayone=view.findViewById(R.id.day_one_cobrastretch);
        dayone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_one_cobra_stretch_class day_one_cobra_stretch_class=new Day_one_cobra_stretch_class();
                day_one_cobra_stretch_class.show(getFragmentManager(),"My Fragment");
                // ye code me is liye lika k me sirf dialog show karta ho is code ka zarye .
                // baki jo funcationality me add karna chahta ho  o to me jo class me banaya he dialog k liye us me change kare ge.
            }
        });
    return view;
    }
}