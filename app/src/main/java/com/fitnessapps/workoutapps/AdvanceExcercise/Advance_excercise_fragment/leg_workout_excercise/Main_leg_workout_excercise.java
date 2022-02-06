package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Arm_workout_excercise.Main_arm_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Chest_workout_excercise.Main_chest_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.abc_workout_excercise.Main_ABC_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.LEG_ACTIVITY_FOLDER.Boat_hol_leg_flutter_ready_togo_leg;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise.Boat_hol_leg_flutters_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise.Bulgarian_split_squat_jump_right_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise.Butt_kick_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise.Inchworm_second_framgent;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise.Jumping_secod_jack_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise.Lunge_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise.Side_hip_abduction_framgnet;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise.Squate_kick_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.leg_excercise.Step_up_on_chair_fragment;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Main_shoulder_workout_excercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayEight;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayFive;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayFour;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayOne;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DaySeven;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DaySix;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayThree;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayTwo;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Four_excercise_Fragment.High_knee_tapFragment;
import com.fitnessapps.workoutapps.R;

public class Main_leg_workout_excercise extends AppCompatActivity {
Button seting,startbtn;
private com.google.android.gms.ads.AdView admobAdview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_leg_workout_excercise);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdmobbannerAds();


        boathollegflutters();
        bulgariansplitsquatjumpright();
        buttkick();
        highkneetap();
        inchworm();
        jumpingjack();
        lunge();
        sidehipabduction();
        squatekick();
        stepuponchair();
        seting=findViewById(R.id.settingbtn);
        startbtn=findViewById(R.id.leg_startbtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main_leg_workout_excercise.this,
                        Boat_hol_leg_flutter_ready_togo_leg.class);
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

    private void stepuponchair() {
        Step_up_on_chair_fragment step_up_on_chair_fragment = new Step_up_on_chair_fragment ();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.step_up_on_chair_container, step_up_on_chair_fragment);
        transaction.commit();
    }

    private void squatekick() {
        Squate_kick_fragment squate_kick_fragment = new Squate_kick_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.squate_kick_container, squate_kick_fragment);
        transaction.commit();
    }

    private void boathollegflutters() {
        Boat_hol_leg_flutters_fragment boat_hol_leg_flutters_fragment = new Boat_hol_leg_flutters_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.boathol_leg_flutters_container, boat_hol_leg_flutters_fragment);
        transaction.commit();
    }
    private void bulgariansplitsquatjumpright() {
        Bulgarian_split_squat_jump_right_fragment bulgarian_split_squat_jump_right_fragment = new Bulgarian_split_squat_jump_right_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.bulgarian_split_squat_jump_right_container, bulgarian_split_squat_jump_right_fragment);
        transaction.commit();
    }
    private void buttkick() {
        Butt_kick_fragment butt_kick_fragment = new Butt_kick_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.buttkick_container, butt_kick_fragment);
        transaction.commit();
    }
    private void highkneetap() {
        High_knee_tapFragment high_knee_tapFragment = new High_knee_tapFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.highknee_tap_container, high_knee_tapFragment);
        transaction.commit();
    }
    private void inchworm() {
        Inchworm_second_framgent inchworm_second_framgent = new Inchworm_second_framgent();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.inchwormSecond_container, inchworm_second_framgent);
        transaction.commit();
    }

    private void jumpingjack() {
        Jumping_secod_jack_fragment jumping_secod_jack_fragment = new Jumping_secod_jack_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.jumpingjack_container, jumping_secod_jack_fragment);
        transaction.commit();
    }

    private void lunge() {
        Lunge_fragment lunge_fragment = new Lunge_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.lunge_second_container, lunge_fragment);
        transaction.commit();
    }

    private void sidehipabduction() {
        Side_hip_abduction_framgnet side_hip_abduction_framgnet = new Side_hip_abduction_framgnet();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.side_hip_abduction_container, side_hip_abduction_framgnet);
        transaction.commit();

    }
    private void DialogBox(){
        final AlertDialog.Builder alert=new AlertDialog.Builder(Main_leg_workout_excercise.this);
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

    public void AdmobbannerAds(){

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getResources().getString(R.string.admob_banner_ads_ids));
        admobAdview = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        admobAdview.loadAd(adRequest);
        admobAdview.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                admobAdview.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }


}