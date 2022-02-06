package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.dayseven;

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
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdView;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

public class Side_lungeto_curtsy_lunkgeright_startExercise extends AppCompatActivity {

    Button done;
    TextView skip, previous;
    AdView admobInterstitialAd;
    InterstitialAd fbinterstitialads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_lungeto_curtsy_lunkgeright_start_exercise);

        done = findViewById(R.id.squat_done);
        skip = findViewById(R.id.squat_skip_textview);
        previous = findViewById(R.id.squat_previous_txtview);


        SquatExerciseDone();
        SkipTextview();
        PreviousTextView();
fbInterstitial_ads();

    }

    private void PreviousTextView() {
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Side_lungeto_curtsy_lunkgeright_startExercise.this,
                        Side_lungeto_curtsy_lunkgeLeft_startExercise.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void SkipTextview() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Side_lungeto_curtsy_lunkgeright_startExercise.this,
                        Side_lungeto_curtsy_lunkgeright_rest.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void SquatExerciseDone() {
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Side_lungeto_curtsy_lunkgeright_startExercise.this,
                        Side_lungeto_curtsy_lunkgeright_rest.class);
                startActivity(intent);
                finish();


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
                        Side_lungeto_curtsy_lunkgeright_startExercise.super.onBackPressed();
                        Intent intent=new Intent(Side_lungeto_curtsy_lunkgeright_startExercise.this,
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