package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.all_day_excercise_class.Day_two_bulgarian_split_suat_jump_left_class;
import com.fitnessapps.workoutapps.R;

public class Bulgarian_split_suat_jump_left extends Fragment {
    View jumpleft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bulgarian_split_suat_jump_left, container, false);
    jumpleft=view.findViewById(R.id.splite_suate_jumpleft);
    jumpleft.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Day_two_bulgarian_split_suat_jump_left_class day_two_bulgarian_split_suat_jump_left_class=new Day_two_bulgarian_split_suat_jump_left_class();
            day_two_bulgarian_split_suat_jump_left_class.show(getFragmentManager(),"suat left");
        }
    });
        return view;
    }
}