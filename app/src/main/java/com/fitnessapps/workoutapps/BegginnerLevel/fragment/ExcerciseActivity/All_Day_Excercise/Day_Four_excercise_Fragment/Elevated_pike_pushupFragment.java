package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Four_excercise_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Four_excercise_Fragment.all_day_excercise_class.Day_four_elevated_pike_pushup_class;
import com.fitnessapps.workoutapps.R;

public class Elevated_pike_pushupFragment extends Fragment {
View bupree;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_elevated_pike_pushup, container, false);
        bupree=view.findViewById(R.id.elevatedpikepushup);
        bupree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_four_elevated_pike_pushup_class day_three_burpee_pushup_class=new Day_four_elevated_pike_pushup_class();
                day_three_burpee_pushup_class.show(getFragmentManager(),"burpee");
            }
        });
        return  view;
    }
}