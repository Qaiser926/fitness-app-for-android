package com.fitnessapps.workoutapps.BegginnerLevel.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.alldietActivity.DietEight_Activity;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.alldietActivity.DietFive_Activity;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.alldietActivity.DietFour_Activity;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.alldietActivity.DietSeven_Activity;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.alldietActivity.DietSix_Activity;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.alldietActivity.DietThree_Activity;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.alldietActivity.DietTwo_Activity;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.alldietActivity.Dietone_Activity;
import com.fitnessapps.workoutapps.R;


public class diet_fragment extends Fragment {
    Button diet1,diet2,diet3,diet4,diet5,diet6,diet7,diet8,diet9,diet10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_diet_fragment, container, false);

        diet1=view.findViewById(R.id.diet_dayone);
        diet2=view.findViewById(R.id.diet_daytwo);
        diet3=view.findViewById(R.id.diet_daythree);
        diet4=view.findViewById(R.id.diet_dayfour);
        diet5=view.findViewById(R.id.diet_dayfive);
        diet6=view.findViewById(R.id.diet_daysix);
        diet7=view.findViewById(R.id.diet_dayseven);
        diet8=view.findViewById(R.id.diet_dayeight);



        diet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Dietone_Activity.class));
            }
        });
        diet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DietTwo_Activity.class));
            }
        });
        diet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DietThree_Activity.class));
            }
        });
        diet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DietFour_Activity.class));
            }
        });
        diet5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DietFive_Activity.class));
            }
        });
        diet6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DietSix_Activity.class));
            }
        });
        diet7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DietSeven_Activity.class));
            }
        });
        diet8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DietEight_Activity.class));
            }
        });
    return view;
    }
}