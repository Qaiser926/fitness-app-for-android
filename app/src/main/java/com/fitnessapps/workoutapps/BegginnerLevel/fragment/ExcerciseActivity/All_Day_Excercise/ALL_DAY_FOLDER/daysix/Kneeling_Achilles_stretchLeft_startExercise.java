package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.daysix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

public class Kneeling_Achilles_stretchLeft_startExercise extends AppCompatActivity {

    Button done;
    TextView skip, previous;
    private InterstitialAd admobInterstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kneeling_achilles_stretch_left_start_exercise);

        done = findViewById(R.id.squat_done);
        skip = findViewById(R.id.squat_skip_textview);
        previous = findViewById(R.id.squat_previous_txtview);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        fbInterstitial_ads();

        SquatExerciseDone();
        SkipTextview();
//        PreviousTextView();


    }

//    private void PreviousTextView() {
//        previous.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Kneeling_Achilles_stretchLeft_startExercise.this,
//                        Deficit_pushup_startExercise.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }

    private void SkipTextview() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kneeling_Achilles_stretchLeft_startExercise.this,
                        Kneeling_Achilles_stretchLeft_rest.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void SquatExerciseDone() {
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (admobInterstitialAd != null) {
                    admobInterstitialAd.show(Kneeling_Achilles_stretchLeft_startExercise.this);
                    admobInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Intent intent = new Intent(Kneeling_Achilles_stretchLeft_startExercise.this,
                                    Kneeling_Achilles_stretchLeft_rest.class);
                            startActivity(intent);
                            finish();
                            admobInterstitialAd=null;
                            SetadmobInterstitialAds();
                        }
                    });
                } else {
                    Intent intent = new Intent(Kneeling_Achilles_stretchLeft_startExercise.this,
                            Kneeling_Achilles_stretchLeft_rest.class);
                    startActivity(intent);
                    finish();

                }


            }
        });
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertbox=new AlertDialog.Builder(this)
                .setMessage("Are You Sure You Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Kneeling_Achilles_stretchLeft_startExercise.super.onBackPressed();
                        Intent intent=new Intent(Kneeling_Achilles_stretchLeft_startExercise.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog=alertbox.create();
        alertDialog.show();

    }
    private void SetadmobInterstitialAds(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,getResources().getString(R.string.admob_interstitial_ads_ids), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                admobInterstitialAd = interstitialAd;
            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the erro
                admobInterstitialAd = null;
            }
        });}
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