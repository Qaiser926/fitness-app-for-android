package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Four_excercise_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Four_excercise_Fragment.all_day_excercise_class.Day_four_flutter_kick_class;
import com.fitnessapps.workoutapps.R;

public class Flutter_kickFragment extends Fragment {
    View bupree;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_flutter_kick, container, false);
        bupree=view.findViewById(R.id.flutterkick);
        bupree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day_four_flutter_kick_class day_three_burpee_pushup_class=new Day_four_flutter_kick_class();
                day_three_burpee_pushup_class.show(getFragmentManager(),"burpee");
            }
        });
        return  view;
    }
}