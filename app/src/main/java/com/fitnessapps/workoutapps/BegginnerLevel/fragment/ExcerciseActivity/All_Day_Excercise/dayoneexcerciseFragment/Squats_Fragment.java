package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.all_excercise_classes.Day_one_squats_class;
import com.fitnessapps.workoutapps.R;

public class Squats_Fragment extends Fragment {

    View day_squate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_squats_, container, false);

      day_squate=view.findViewById(R.id.day_one_squate);
      day_squate.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Day_one_squats_class day_one_squats_class=new Day_one_squats_class();
              day_one_squats_class.show(getFragmentManager(),"My Squats Faragment");
          }
      });
        return  view;
    }
}