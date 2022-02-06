package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Arm_workout_excercise.Main_arm_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Chest_workout_excercise.Main_chest_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.abc_workout_excercise.Main_ABC_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.Main_leg_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.SHOULDER_ACTIVITY_FOLDER.Cross_knee_tricept_ready_togo;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Shoulder_excercise.Cross_knee_tricep_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Shoulder_excercise.Leg_riser_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Shoulder_excercise.Shoulder_jumping_jack_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Shoulder_excercise.Side_plank_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Shoulder_excercise.Tricep_curl_Fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Shoulder_excercise.Warm_up_guy_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Shoulder_excercise.Yoga_pose_fragmnet;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayEight;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayFive;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayFour;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayOne;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DaySeven;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DaySix;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayThree;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayTwo;
import com.fitnessapps.workoutapps.R;

public class Main_shoulder_workout_excercise extends AppCompatActivity {

    Button seting,startbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_shoulder_workout_excercise);

        crosskneetricep();
        jumpingjackexcercise();
        legriser();
        sideplank();
        tricep();
        warmupguy();
        yogapose();

        seting=findViewById(R.id.settingbtn);
        startbtn=findViewById(R.id.shoulder_startbtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main_shoulder_workout_excercise.this,
                        Cross_knee_tricept_ready_togo.class);
                startActivity(intent);
                finish();
            }
        });
        seting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogBox();
            }
        });
    }

    private void legriser() {
        Leg_riser_fragment leg_riser_fragment = new Leg_riser_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.shoulder_legriser_contianer, leg_riser_fragment);
        transaction.commit();
    }

    private void crosskneetricep() {
        Cross_knee_tricep_fragment cross_knee_tricep_fragment = new Cross_knee_tricep_fragment ();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.shoulder_cross_knee_tricep_container, cross_knee_tricep_fragment);
        transaction.commit();
    }

    private void jumpingjackexcercise() {
        Shoulder_jumping_jack_fragment shoulder_jumping_jack_fragment = new Shoulder_jumping_jack_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.shoulder_jumping_container, shoulder_jumping_jack_fragment);
        transaction.commit();
    }
    private void sideplank() {
        Side_plank_fragment side_plank_fragment = new Side_plank_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.shoulder_side_plank_container, side_plank_fragment);
        transaction.commit();
    }
    private void tricep() {
        Tricep_curl_Fragment tricep_curl_fragment = new Tricep_curl_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.shoulder_tricep_curl_container, tricep_curl_fragment);
        transaction.commit();
    }
    private void warmupguy() {
        Warm_up_guy_fragment warm_up_guy_fragment = new Warm_up_guy_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.shoulder_warm_up_guy_container, warm_up_guy_fragment);
        transaction.commit();
    }
    private void yogapose() {
        Yoga_pose_fragmnet yoga_pose_fragmnet = new Yoga_pose_fragmnet();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.shoulder_yoga_pose_container, yoga_pose_fragmnet);
        transaction.commit();
    }
    private void DialogBox(){
        final AlertDialog.Builder alert=new AlertDialog.Builder(Main_shoulder_workout_excercise.this);
//               AlertDialog.Builder alert=new AlertDialog.Builder(getApplicationContext());
        View view= getLayoutInflater().inflate(R.layout.setting_layout,null);
        TextView chestExerciise=view.findViewById(R.id.setting_chestexercise);
        TextView legexercise=view.findViewById(R.id.setting_legexercise);
        TextView shoulderexercise=view.findViewById(R.id.setting_shoulderexercise);
        TextView armexercise=view.findViewById(R.id.setting_armexercise);
        TextView abcexercise=view.findViewById(R.id.setting_abcexercise);
        TextView dayone=view.findViewById(R.id.setting_dayone);
        TextView daytwo=view.findViewById(R.id.setting_daytwo);
        TextView daythree=view.findViewById(R.id.setting_daythree);
        TextView dayfour=view.findViewById(R.id.setting_dayfour);
        TextView dayfive=view.findViewById(R.id.setting_dayfive);
        TextView daysix=view.findViewById(R.id.setting_daysix);
        TextView dayseven=view.findViewById(R.id.setting_dayseven);
        TextView dayeight=view.findViewById(R.id.setting_dayeight);
        TextView cancel=view.findViewById(R.id.setting_cencel);

        alert.setView(view);
        final AlertDialog alertDialog=alert.create();
//               alertDialog.setCanceledOnTouchOutside(false);

        chestExerciise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), Main_chest_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        legexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Main_leg_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        shoulderexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Main_shoulder_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        armexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Main_arm_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        abcexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Main_ABC_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        daytwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), DayTwo.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        daythree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), DayThree.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), DayFour.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), DayFive.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        daysix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), DaySix.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), DaySeven.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), DayEight.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), DayOne.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
    }