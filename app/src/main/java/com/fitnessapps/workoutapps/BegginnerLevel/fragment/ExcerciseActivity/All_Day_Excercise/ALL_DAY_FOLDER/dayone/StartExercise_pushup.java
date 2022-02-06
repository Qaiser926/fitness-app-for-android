package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.dayone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

public class StartExercise_pushup extends AppCompatActivity {

    Button done;
    TextView skip, previous;
    private InterstitialAd fbinterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exercise_pushup);

        done = findViewById(R.id.squat_done);
        skip = findViewById(R.id.squat_skip_textview);
        previous = findViewById(R.id.squat_previous_txtview);

        AudienceNetworkAds.initialize(this);
        InterStititialAdsMethod();
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
// Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
// Add the ad view to your activity layout
        adContainer.addView(adView);
// Request an ad
        adView.loadAd();

        SquatExerciseDone();
        SkipTextview();
        PreviousTextView();

    }

    private void PreviousTextView() {
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartExercise_pushup.this,
                        StartExercise_abdominalcrunches.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void SkipTextview() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartExercise_pushup.this,
                        PushUp_restActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void SquatExerciseDone() {
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartExercise_pushup.this,
                        PushUp_restActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertbox = new AlertDialog.Builder(this)
                .setMessage("Are You Sure You Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StartExercise_pushup.super.onBackPressed();
                        Intent intent = new Intent(StartExercise_pushup.this,
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
        AlertDialog alertDialog = alertbox.create();
        alertDialog.show();

    }

    private void InterStititialAdsMethod() {
        fbinterstitialAd = new InterstitialAd(this, getResources().getString(R.string.fb_interstitial_ads));
        // Create listeners for the Interstitial Ad
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {
            }

            @Override
            public void onAdLoaded(Ad ad) {
                fbinterstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        fbinterstitialAd.loadAd(
                fbinterstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (fbinterstitialAd != null) {
            fbinterstitialAd.destroy();

        }
    }
    }

