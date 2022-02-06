package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.dayone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class ReverseCrunches_Ready_togo_activity extends AppCompatActivity {

    CircularView circularViewWithTimer;
    TextView textView;
    MediaPlayer mediaPlayer;
    AdView admobAdview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_crunches_ready_togo);

        circularViewWithTimer = findViewById(R.id.circular_view);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
// Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
// Add the ad view to your activity layout
        adContainer.addView(adView);
// Request an ad
        adView.loadAd();



        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(10)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

//                                 Will be called if times up of countdown timer

                                Intent intent=new Intent(ReverseCrunches_Ready_togo_activity.this,
                                        ReverseCraches_StartExercise.class);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onTimerCancelled() {

                                // Will be called if stopTimer is called
                                circularViewWithTimer.setVisibility(View.INVISIBLE);
                            }
                        });
//        mediaPlayer=MediaPlayer.create(Ready_togo_activity.this,R.raw.tick);
//        mediaPlayer.start();

        circularViewWithTimer.setOptions(builderWithTimer);
        circularViewWithTimer.startTimer();
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertbox=new AlertDialog.Builder(this)
                .setMessage("Are You Sure To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ReverseCrunches_Ready_togo_activity.super.onBackPressed();
                        Intent intent=new Intent(ReverseCrunches_Ready_togo_activity.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                        circularViewWithTimer.stopTimer();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        circularViewWithTimer.resumeTimer();
                    }
                });
        AlertDialog alertDialog=alertbox.create();
        alertDialog.show();
        circularViewWithTimer.pauseTimer();
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