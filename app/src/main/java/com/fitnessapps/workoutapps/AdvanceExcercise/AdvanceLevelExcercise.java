package com.fitnessapps.workoutapps.AdvanceExcercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.ABC_Workouut_Fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Arm_Workout_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Chest_Workout_Fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Leg_Workout_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Shoulder_workout_Fragment;
import com.fitnessapps.workoutapps.R;

public class AdvanceLevelExcercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_level_excercise);

       abc();
        shoulder();
        chestworkdout();
        shoulder();
        legworkout();
        Armworkout();
    }

    private void Armworkout() {
        Arm_Workout_fragment arm_workout_fragment=new Arm_Workout_fragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.arm_container,arm_workout_fragment);
        transaction.commit();
    }

    private void legworkout() {
        Leg_Workout_fragment leg_workout_fragment=new Leg_Workout_fragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.leg_container,leg_workout_fragment);
        transaction.commit();
    }

    private void chestworkdout() {
        Chest_Workout_Fragment chest_workout_fragment=new Chest_Workout_Fragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.chestExcercise_container,chest_workout_fragment);
        transaction.commit();
    }

    private void shoulder() {
        Shoulder_workout_Fragment shoulder_workout_fragment=new Shoulder_workout_Fragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.shoulder_and_back_container,shoulder_workout_fragment);
        transaction.commit();
    }

    private void abc() {
        ABC_Workouut_Fragment abc_workouut_fragment=new ABC_Workouut_Fragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.abc_container,abc_workouut_fragment);
        transaction.commit();

    }
}