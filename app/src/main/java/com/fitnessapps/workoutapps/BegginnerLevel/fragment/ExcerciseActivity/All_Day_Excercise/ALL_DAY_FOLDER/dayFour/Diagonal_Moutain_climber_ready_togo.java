package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.dayFour;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class Diagonal_Moutain_climber_ready_togo extends AppCompatActivity {

    CircularView circularViewWithTimer;
    TextView textView;
    MediaPlayer mediaPlayer;
    private AdView fbadview;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagonal_moutain_climber_ready_togo);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AudienceNetworkAds.initialize(this);
        InterStititialAdsMethod();
        fbBannerAds();
        circularViewWithTimer = findViewById(R.id.circular_view);
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(10)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

//                                 Will be called if times up of countdown timer

                                Intent intent=new Intent(Diagonal_Moutain_climber_ready_togo.this,
                                        Diagonal_Moutain_climber_startExercise.class);
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
                .setMessage("Are You Sure You Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Diagonal_Moutain_climber_ready_togo.super.onBackPressed();
                        Intent intent=new Intent(Diagonal_Moutain_climber_ready_togo.this,
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
    private void fbBannerAds(){
        fbadview = new AdView(this, getResources().getString(R.string.fb_bannner_ads), AdSize.BANNER_HEIGHT_50);
        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        // Add the ad view to your activity layout
        adContainer.addView(fbadview);
        // Request an ad
        fbadview.loadAd();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (fbadview!=null){
            fbadview.destroy();
        }
        if (fbinterstitialAd!=null){
            fbinterstitialAd.destroy();
        }
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

}