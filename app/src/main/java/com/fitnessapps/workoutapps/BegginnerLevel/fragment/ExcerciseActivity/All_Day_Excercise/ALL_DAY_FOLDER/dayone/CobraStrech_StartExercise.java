package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.dayone;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

import java.util.Locale;

public class CobraStrech_StartExercise extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS=50000;
    private TextView mTextviewcountdown;
    private Button mButtonstartpause,mButtonReset;

    private CountDownTimer mcountdowntimer;
    private boolean mtimerRunning;
    private long mTimerleftInMilles=START_TIME_IN_MILLIS;
    private long mEndTime;

    InterstitialAd fbinterstitialads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobra_strech_start_exercise);

        mTextviewcountdown=findViewById(R.id.text_view_countdown);
        mButtonstartpause=findViewById(R.id.mountainclimber_pause);
        mButtonReset=findViewById(R.id.mountainclimber_restart);
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
// Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
// Add the ad view to your activity layout
        adContainer.addView(adView);
// Request an ad
        adView.loadAd();

        PasueButton();
        RestartButton();
fbInterstitial_ads();
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
//                DayTwo_Rest_Fragment rest_fragment=new DayTwo_Rest_Fragment();
//                FragmentManager manager=getSupportFragmentManager();
//                FragmentTransaction transaction=manager.beginTransaction();
//                transaction.replace(R.id.main_mountainclimber_layout,rest_fragment);
//                transaction.commit();
                Intent intent=new Intent(CobraStrech_StartExercise.this,
                        CobraStretch_rest_activity.class);
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
        Intent intent=new Intent(CobraStrech_StartExercise.this,CobraStretch_rest_activity.class);
        startActivity(intent);
        finish();
    }
    public void mountainclimber_previousbtn(View view) {
        Intent intent=new Intent(CobraStrech_StartExercise.this, Plank_StartExercise.class);
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
        SharedPreferences prefs = CobraStrech_StartExercise.this.getSharedPreferences("Prefs",MODE_PRIVATE);
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
                        CobraStrech_StartExercise.super.onBackPressed();
                        Intent intent=new Intent(CobraStrech_StartExercise.this,
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