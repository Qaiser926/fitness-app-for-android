package com.fitnessapps.workoutapps.BegginnerLevel.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.MainButtonExcercise.DayEightExcercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.MainButtonExcercise.DayFiveExcercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.MainButtonExcercise.DayFourExcercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.MainButtonExcercise.DaySevenExcercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.MainButtonExcercise.DaySixExcercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.MainButtonExcercise.DayThreeExcercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.MainButtonExcercise.DayTwoExcercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.MainButtonExcercise.DayoneExcercise;
import com.fitnessapps.workoutapps.R;

public class Excercise_fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_excercise_fragment, container, false);
        dayone(); daytwo(); daythree(); dayfour(); dayfive(); daysix(); dayseven(); dayeight();

        return view;
    }
//    private void dayten() {
//
//        FragmentTransaction fragmentTransaction10=getFragmentManager().beginTransaction()
//                .replace(R.id.dietdayten_container,new DayTenExcercise());
//        fragmentTransaction10.commit();
//    }
//    private void daynine() {
//        FragmentTransaction fragmentTransaction9=getFragmentManager().beginTransaction()
//                .replace(R.id.dietdaynine_container,new DayNineExcercise());
//        fragmentTransaction9.commit();
//    }
    private void dayeight() {
        FragmentTransaction fragmentTransaction8=getFragmentManager().beginTransaction()
                .replace(R.id.dietdayeight_container,new DayEightExcercise());
        fragmentTransaction8.commit();
    }
    private void dayseven() {
        FragmentTransaction fragmentTransaction7=getFragmentManager().beginTransaction()
                .replace(R.id.dietdayseven_container,new DaySevenExcercise());
        fragmentTransaction7.commit();
    }
    private void daysix() {
        FragmentTransaction fragmentTransaction6=getFragmentManager().beginTransaction()
                .replace(R.id.dietdaysix_container,new DaySixExcercise());
        fragmentTransaction6.commit();
    }
    private void dayfive() {
        FragmentTransaction fragmentTransaction4=getFragmentManager().beginTransaction()
                .replace(R.id.dietdayfive_container,new DayFiveExcercise());
        fragmentTransaction4.commit();
    }
    private void dayfour() {
        FragmentTransaction fragmentTransaction3=getFragmentManager().beginTransaction()
                .replace(R.id.dietdayfour_container,new DayFourExcercise());
        fragmentTransaction3.commit();
    }
    private void daythree() {
        FragmentTransaction fragmentTransaction2=getFragmentManager().beginTransaction()
                .replace(R.id.dietdaythre_container,new DayThreeExcercise());
        fragmentTransaction2.commit();
    }
    private void daytwo() {
        FragmentTransaction fragmentTransaction1=getFragmentManager().beginTransaction()
                .replace(R.id.dietdaytwo_container,new DayTwoExcercise());
        fragmentTransaction1.commit();
    }
    private void dayone() {
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction()
                .replace(R.id.dayonecontainer,new DayoneExcercise());
        fragmentTransaction.commit();
    }

}