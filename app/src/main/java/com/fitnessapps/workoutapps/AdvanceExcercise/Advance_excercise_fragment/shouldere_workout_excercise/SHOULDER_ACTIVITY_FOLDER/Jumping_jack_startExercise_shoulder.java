package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.shouldere_workout_excercise.SHOULDER_ACTIVITY_FOLDER;

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
import com.facebook.ads.AdSize;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdView;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

public class Jumping_jack_startExercise_shoulder extends AppCompatActivity {

    Button done;
    TextView skip, previous;
    AdView admobInterstitialAd;
    InterstitialAd fbinterstitialads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumping_jack_start_exercise_shoulder);

        done = findViewById(R.id.squat_done);
        skip = findViewById(R.id.squat_skip_textview);
        previous = findViewById(R.id.squat_previous_txtview);
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), AdSize.BANNER_HEIGHT_50);
// Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
// Add the ad view to your activity layout
        adContainer.addView(adView);
// Request an ad
        adView.loadAd();
        fbInterstitial_ads();

        SquatExerciseDone();
        SkipTextview();
        PreviousTextView();


    }

    private void PreviousTextView() {
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jumping_jack_startExercise_shoulder.this,
                        Cross_knee_tricept_startExercise_shoulder.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void SkipTextview() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jumping_jack_startExercise_shoulder.this,
                        Jumping_jack_rest_shoulder.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void SquatExerciseDone() {
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Jumping_jack_startExercise_shoulder.this,
                        Jumping_jack_rest_shoulder.class);
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
                        Jumping_jack_startExercise_shoulder.super.onBackPressed();
                        Intent intent=new Intent(Jumping_jack_startExercise_shoulder.this,
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