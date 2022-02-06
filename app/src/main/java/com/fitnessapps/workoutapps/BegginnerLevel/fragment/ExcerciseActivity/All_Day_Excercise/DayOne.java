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
import com.google.android.gms.ads.AdView;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Arm_workout_excercise.Main_arm_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.Chest_workout_excercise.Main_chest_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.abc_workout_excercise.Main_ABC_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.leg_workout_excercise.Main_leg_workout_excercise;
import com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.Main_shoulder_workout_excercise;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.dayone.Ready_togo_activity;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.AbdominalCrunches_Fragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.CobraStretch_Fragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.MountainerClimber_fragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.Plank_fragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.Puch_up_fragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.ReverseCruches_Fragment;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.dayoneexcerciseFragment.Squats_Fragment;
import com.fitnessapps.workoutapps.R;

public class DayOne extends AppCompatActivity {

    AdView admobbanner_ads;
    InterstitialAd fbinterstitialads;
    Button seting,startbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain_climber);




        seting=(Button) findViewById(R.id.settingbtn);
        startbtn=findViewById(R.id.day_one_startbtn);
       seting.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DialogBox();

           }
       });
       startbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(DayOne.this, Ready_togo_activity.class);
               startActivity(intent);
               finish();
           }
       });

        // jab fragment replace kare activity me to ye code like ge
        mountainclimberexcercise();
        squatsexcercise();
        AbdominalCruncheexcercise();
        push_up();
        plank();
        cobrastretch();
        reversecrunche();

        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
// Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
// Add the ad view to your activity layout
        adContainer.addView(adView);
// Request an ad
        adView.loadAd();

        fbInterstitial_ads();

    }

    private void reversecrunche() {
        ReverseCruches_Fragment reverseCruches_fragment = new ReverseCruches_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.reversecrunches_container, reverseCruches_fragment);
        transaction.commit();
    }
    private void cobrastretch() {
        CobraStretch_Fragment cobraStretch_fragment = new CobraStretch_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.cobrastretch_container, cobraStretch_fragment);
        transaction.commit();
    }
    private void plank() {
        Plank_fragment plank_fragment = new Plank_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.plank_container, plank_fragment);
        transaction.commit();
    }
    private void push_up() {
        Puch_up_fragment puch_up_fragment = new Puch_up_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.puch_up_container, puch_up_fragment);
        transaction.commit();
    }
    private void AbdominalCruncheexcercise() {
        AbdominalCrunches_Fragment abdominalCrunches_fragment = new AbdominalCrunches_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.abdominalcrunches_contianer, abdominalCrunches_fragment);
        transaction.commit();
    }
    private void squatsexcercise() {
        Squats_Fragment squats_fragment = new Squats_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.squats_container, squats_fragment);
        transaction.commit();
    }
    private void mountainclimberexcercise() {
        MountainerClimber_fragment mountainerClimber_fragment = new MountainerClimber_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.mountain_climber_contianer, mountainerClimber_fragment);
        transaction.commit();
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

    private void DialogBox(){
    final AlertDialog.Builder alert=new AlertDialog.Builder(DayOne.this);
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
            Intent intent=new Intent(DayOne.this, Main_leg_workout_excercise.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    });
        shoulderexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, Main_shoulder_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        armexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, Main_arm_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        abcexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, Main_ABC_workout_excercise.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        daytwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, DayTwo.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        daythree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, DayThree.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, DayFour.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, DayFive.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        daysix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, DaySix.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, DaySeven.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        dayeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, DayEight.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        dayone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DayOne.this, DayOne.class);
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