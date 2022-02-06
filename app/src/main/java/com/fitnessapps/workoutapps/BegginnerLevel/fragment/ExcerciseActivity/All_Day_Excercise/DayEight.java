package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Arm_workout_excercise.Main_arm_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Chest_workout_excercise.Main_chest_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.abc_workout_excercise.Main_ABC_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.Main_leg_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Main_shoulder_workout_excercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.dayeight.Bike_pushup_ready_togo;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet.Flutter_kick_second_Fragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet.Prone_chest_stretch_leftFragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet.Prone_chest_stretch_rightFragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet.Russian_twistFragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet.Shoulders_stretchFragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet.Side_lungFragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.Day_Eight_ExcerciseFragmnet.Wiper_secondFragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Bike_push_up;
import com.fitnessapps.workoutapps.R;

public class DayEight extends AppCompatActivity {

    Button seting,startbtn;
    InterstitialAd fbinterstitialads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_eight);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Bikepushup();
        flutterkick();
        pronecheststretchleft();
        pronecheststretchright();
        russiantwist();
        shouldersstretch();
        sidelunge();
        wipersecond();
        fbInterstitial_ads();
//        StartButton();
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
// Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
// Add the ad view to your activity layout
        adContainer.addView(adView);
// Request an ad
        adView.loadAd();


        seting=findViewById(R.id.dayeightsetingbtn);
        startbtn=findViewById(R.id.day_eight_startbtn);
        seting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogBox();
            }
        });
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DayEight.this, Bike_pushup_ready_togo.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void Bikepushup() {
        Bike_push_up bike_push_up = new Bike_push_up();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.bike_push_up_container, bike_push_up);
        transaction.commit();
    }

    private void flutterkick() {
        Flutter_kick_second_Fragment flutter_kick_second_fragment = new Flutter_kick_second_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.flutter_kick_container, flutter_kick_second_fragment);
        transaction.commit();
    }

    private void pronecheststretchleft() {
        Prone_chest_stretch_leftFragment prone_chest_stretch_leftFragment = new Prone_chest_stretch_leftFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.prone_chest_stretch_left_container, prone_chest_stretch_leftFragment);
        transaction.commit();
    }

    private void pronecheststretchright() {
        Prone_chest_stretch_rightFragment prone_chest_stretch_rightFragment = new Prone_chest_stretch_rightFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.prone_chest_stretch_right_container, prone_chest_stretch_rightFragment);
        transaction.commit();
    }

    private void russiantwist() {
        Russian_twistFragment russian_twistFragment = new Russian_twistFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.russian_twist_container, russian_twistFragment);
        transaction.commit();
    }

    private void shouldersstretch() {
        Shoulders_stretchFragment shoulders_stretchFragment = new Shoulders_stretchFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.shoulders_stretch_container, shoulders_stretchFragment);
        transaction.commit();
    }

    private void sidelunge() {
        Side_lungFragment side_lungFragment = new Side_lungFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.side_lung_container, side_lungFragment);
        transaction.commit();
    }

    private void wipersecond() {
        Wiper_secondFragment wiper_secondFragment = new Wiper_secondFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.wipersecond_container, wiper_secondFragment);
        transaction.commit();
    }
    private void DialogBox(){
        final AlertDialog.Builder alert=new AlertDialog.Builder(DayEight.this);
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
    private void fbInterstitial_ads(){
        AudienceNetworkAds.initialize(this);
        fbinterstitialads = new InterstitialAd(this, getResources().getString(R.string.fb_interstitial_ads));
        // Create listeners for the Interstitial Ad
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                // Show the ad
                fbinterstitialads.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback

            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        fbinterstitialads.loadAd(
                fbinterstitialads.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());
    }
    @Override
    protected void onDestroy() {
        if (fbinterstitialads != null) {
            fbinterstitialads.destroy();
        }
        super.onDestroy();
    }

}