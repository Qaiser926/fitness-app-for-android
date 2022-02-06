package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.daythree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

import java.util.Locale;

public class CamalPose_startExercise extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS=100000;
    private TextView mTextviewcountdown,prev,skip;
    private Button mButtonstartpause,mButtonReset;

    private CountDownTimer mcountdowntimer;
    private boolean mtimerRunning;
    private long mTimerleftInMilles=START_TIME_IN_MILLIS;
    private long mEndTime;

    private InterstitialAd admbInterstitial;
    private AdView admobAdview;
    com.facebook.ads.InterstitialAd fbinterstitialads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camal_pose_start_exercise);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mTextviewcountdown=findViewById(R.id.text_view_countdown);
        mButtonstartpause=findViewById(R.id.mountainclimber_pause);
        mButtonReset=findViewById(R.id.mountainclimber_restart);
        prev=findViewById(R.id.prevs);
        skip=findViewById(R.id.skips);

        fbInterstitial_ads();
        AdmobbannerAds();
        PasueButton();
        RestartButton();
        PreviousTextView();
        SkipTextView();

    }
    private void PasueButton() {
        mButtonstartpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mtimerRunning){
                    PauseTimer();
                }
                else
                {
                    Starttimer();
                }
            }
        });

    }
    private void RestartButton(){
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownTExt();
    }
    private void PauseTimer(){
        mcountdowntimer.cancel();
        mtimerRunning=false;
//        mButtonstartpause.setText("Resume");
//        mButtonReset.setVisibility(View.VISIBLE);
        updarteButton();
    }
    private void Starttimer(){
        mEndTime=System.currentTimeMillis() + mTimerleftInMilles;

        mcountdowntimer=new CountDownTimer(mTimerleftInMilles,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimerleftInMilles=millisUntilFinished;
                updateCountDownTExt();

            }
            @Override
            public void onFinish() {
                mtimerRunning=false;
                updarteButton();
                Intent intent=new Intent(CamalPose_startExercise.this,
                        CamalPose_rest.class);
                startActivity(intent);
                finish();
            }
        }.start();
        mtimerRunning=true;
        updarteButton();

    }
    private void resetTimer(){
        mTimerleftInMilles=START_TIME_IN_MILLIS;
        updateCountDownTExt();
        updarteButton();
    }
    private void updateCountDownTExt() {
        int minute=(int) (mTimerleftInMilles/1000)/60;
        int second=(int) (mTimerleftInMilles/1000)%60;
        String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d",minute,second);
        mTextviewcountdown.setText(timeLeftFormatted);
    }
    public void mountainclimber_skipbtn(View view) {
//        Rest_Fragment rest_fragment=new Rest_Fragment();
//        FragmentManager manager=getSupportFragmentManager();
//        FragmentTransaction transaction=manager.beginTransaction();
//        transaction.replace(R.id.main_mountainclimber_layout,rest_fragment);
//        transaction.commit();
        Intent intent=new Intent(CamalPose_startExercise.this,CamalPose_rest.class);
        startActivity(intent);
        finish();
    }
    public void mountainclimber_previousbtn(View view) {
        Intent intent=new Intent(CamalPose_startExercise.this, Burpee_pushup_startExercise.class);
        startActivity(intent);
        finish();
    }

    // ye niche code me rotate screen k liye lika he

    private void updarteButton(){
        if (mtimerRunning){
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonstartpause.setText("Pasue");
        }else
        {
            mButtonstartpause.setText("Start");
            if (mTimerleftInMilles<1000){
                mButtonstartpause.setVisibility(View.INVISIBLE);
            }else {
                mButtonstartpause.setVisibility(View.VISIBLE);
            }
            if (mTimerleftInMilles<START_TIME_IN_MILLIS){
                mButtonReset.setVisibility(View.VISIBLE);
            }else
            {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("millisLeft",mTimerleftInMilles);
        outState.putBoolean("timerRunning",mtimerRunning);
        outState.putLong("endTime",mEndTime);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTimerleftInMilles=savedInstanceState.getLong("millisLeft");
        mtimerRunning=savedInstanceState.getBoolean("timerRunning");
        updateCountDownTExt();
        updarteButton();

        if (mtimerRunning){
            mEndTime=savedInstanceState.getLong("endTime");
            mTimerleftInMilles=mEndTime-System.currentTimeMillis();

            Starttimer();
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences prefs = CamalPose_startExercise.this.getSharedPreferences("Prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("starttimeInMillis", mTimerleftInMilles);
        editor.putLong("millisLeft", mTimerleftInMilles);
        editor.putBoolean("timerRunning", mtimerRunning);
        editor.putLong("endTime", mEndTime);
        editor.apply();

        if (mcountdowntimer != null) {
            mcountdowntimer.cancel();

        }

    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertbox=new AlertDialog.Builder(this)
                .setMessage("Are You Sure You Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CamalPose_startExercise.super.onBackPressed();
                        Intent intent=new Intent(CamalPose_startExercise.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                        mcountdowntimer.cancel();

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
    private void PreviousTextView(){
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CamalPose_startExercise.this,
                        Burpee_pushup_startExercise.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void SkipTextView(){
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CamalPose_startExercise.this,
                        CamalPose_rest.class);
                startActivity(intent);
                finish();
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
