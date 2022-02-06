package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise;

import androidx.annotation.NonNull;
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
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Arm_workout_excercise.Main_arm_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Chest_workout_excercise.Main_chest_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.abc_workout_excercise.Main_ABC_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.Main_leg_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Main_shoulder_workout_excercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.daytwo.Backtwist_ready_Togo;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Back_twists;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Bicycler_crunch;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Bike_push_up;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Boat_hold_leg_flutters;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Box_glute_stretch_left;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Box_glute_stretch_right;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Bulgarian_split_squat_jump_left;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Bulgarian_split_suat_jump_left;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.daytwoexcerciseFragment.Bulgarian_split_suat_jump_right;
import com.fitnessapps.workoutapps.R;

public class DayTwo extends AppCompatActivity {

    Button seting, daytwo_startbtn;
    InterstitialAd admobInterstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_two);

        daytwo_startbtn = findViewById(R.id.day_two_startbtn);
        seting = findViewById(R.id.settingbtn);

        backtwist();
        bicyclercrunch();
        bikepushup();
        boatholdlegflutter();
        boxglutestretchleft();
        boxglutestretchright();
        bulgariansplitsquatjumpleft();
        bulgariansplitsuatjumpLeft();
        bulgariansplitsuatjumpright();

        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
// Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
// Add the ad view to your activity layout
        adContainer.addView(adView);
// Request an ad
        adView.loadAd();

        // buton method function call
        StartButton_call();
        // ads call

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        fbInterstitial_ads();


        seting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogBox();
            }
        });
    }

    private void bulgariansplitsuatjumpright() {
        Bulgarian_split_suat_jump_right bulgarian_split_suat_jump_right = new Bulgarian_split_suat_jump_right();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.bulgarian_split_suat_jump_right_container, bulgarian_split_suat_jump_right);
        transaction.commit();
    }

    private void bulgariansplitsuatjumpLeft() {
        Bulgarian_split_suat_jump_left bulgarian_split_suat_jump_left = new Bulgarian_split_suat_jump_left();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.bulgarian_split_suat_jump_left_container, bulgarian_split_suat_jump_left);
        transaction.commit();
    }

    private void bulgariansplitsquatjumpleft() {
        Bulgarian_split_squat_jump_left bulgarian_split_squat_jump_left = new Bulgarian_split_squat_jump_left();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.bulgarian_split_squat_jump_left_container, bulgarian_split_squat_jump_left);
        transaction.commit();
    }

    private void boxglutestretchright() {
        Box_glute_stretch_right box_glute_stretch_right = new Box_glute_stretch_right();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.box_glute_stretch_right_container, box_glute_stretch_right);
        transaction.commit();
    }

    private void boxglutestretchleft() {
        Box_glute_stretch_left box_glute_stretch_left = new Box_glute_stretch_left();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.box_glute_stretch_left_container, box_glute_stretch_left);
        transaction.commit();
    }

    private void boatholdlegflutter() {
        Boat_hold_leg_flutters boat_hold_leg_flutters = new Boat_hold_leg_flutters();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.boat_hold_leg_flutters_container, boat_hold_leg_flutters);
        transaction.commit();
    }

    private void bikepushup() {
        Bike_push_up bike_push_up = new Bike_push_up();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.bike_push_up_container, bike_push_up);
        transaction.commit();
    }

    private void bicyclercrunch() {
        Bicycler_crunch bicycler_crunch = new Bicycler_crunch();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.bicycler_crunch_container, bicycler_crunch);
        transaction.commit();
    }

    private void backtwist() {
        Back_twists back_twists = new Back_twists();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.back_twists_container, back_twists);
        transaction.commit();
    }

    private void DialogBox() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(DayTwo.this);
//               AlertDialog.Builder alert=new AlertDialog.Builder(getApplicationContext());
        View view = getLayoutInflater().inflate(R.layout.setting_layout, null);
        TextView chestExerciise = view.findViewById(R.id.setting_chestexercise);
        TextView legexercise = view.findViewById(R.id.setting_legexercise);
        TextView shoulderexercise = view.findViewById(R.id.setting_shoulderexercise);
        TextView armexercise = view.findViewById(R.id.setting_armexercise);
        TextView abcexercise = view.findViewById(R.id.setting_abcexercise);
        TextView dayone = view.findViewById(R.id.setting_dayone);
        TextView daytwo = view.findViewById(R.id.setting_daytwo);
        TextView daythree = view.findViewById(R.id.setting_daythree);
        TextView dayfour = view.findViewById(R.id.setting_dayfour);
        TextView dayfive = view.findViewById(R.id.setting_dayfive);
        TextView daysix = view.findViewById(R.id.setting_daysix);
        TextView dayseven = view.findViewById(R.id.setting_dayseven);
        TextView dayeight = view.findViewById(R.id.setting_dayeight);
        TextView cancel = view.findViewById(R.id.setting_cencel);

        alert.setView(view);
        final AlertDialog alertDialog = alert.create();
//               alertDialog.setCanceledOnTouchOutside(false);

        chestExerciise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main_chest_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        legexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main_leg_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        shoulderexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main_shoulder_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        armexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main_arm_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        abcexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main_ABC_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        daytwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DayTwo.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        daythree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DayThree.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DayFour.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DayFive.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        daysix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DaySix.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DaySeven.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DayEight.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DayOne.class);
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

    private void StartButton_call() {
        daytwo_startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (admobInterstitialAd != null) {
                    admobInterstitialAd.show(DayTwo.this);
                    admobInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Intent intent = new Intent(DayTwo.this, Backtwist_ready_Togo.class);
                            startActivity(intent);
                            finish();
                            admobInterstitialAd=null;
                            SetadmobInterstitialAds();
                        }
                    });
                } else {
                    Intent intent = new Intent(DayTwo.this, Backtwist_ready_Togo.class);
                    startActivity(intent);
                    finish();

                }

            }
        });
    }

    private void SetadmobInterstitialAds() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, getResources().getString(R.string.admob_interstitial_ads_ids), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                admobInterstitialAd = interstitialAd;
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error

                admobInterstitialAd = null;
            }
        });

    }
    private void fbInterstitial_ads(){
        AudienceNetworkAds.initialize(this);
        fbinterstitialads = new com.facebook.ads.InterstitialAd(this, getResources().getString(R.string.fb_interstitial_ads));
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