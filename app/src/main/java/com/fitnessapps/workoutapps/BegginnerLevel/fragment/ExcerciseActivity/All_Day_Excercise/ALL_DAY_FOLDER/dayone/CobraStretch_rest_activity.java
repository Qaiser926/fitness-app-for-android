package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.dayone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

import java.util.Locale;

public class CobraStretch_rest_activity extends AppCompatActivity {

    private EditText mEditTextInput;
    private Button mButonset;
    private TextView mTextviewcountdown,nextbtn;
    private Button mButtonstartpause, mButtonReset;
    private CountDownTimer mcountdowntimer;
    private boolean mtimerRunning;
    private long mStartTimeINMillis;
    private long mTimerleftInMilles = mStartTimeINMillis;
    private long mEndTime;
    InterstitialAd fbinterstitialads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobra_stretch_rest);
        mTextviewcountdown = findViewById(R.id.reset_textview_countdown);
        mButtonstartpause = findViewById(R.id.rest_mountainclimber_start);
        mButtonReset = findViewById(R.id.rest_mountainclimber_reset);
        mEditTextInput=findViewById(R.id.edit_text_input);
        mButonset=findViewById(R.id.button_set);
        nextbtn=findViewById(R.id.dayone_rest_nextbtn);
        PasueButton();
        RestartButton();
        mButtonSet();
        fbInterstitial_ads();
        NextACtivity_btn();
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
// Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
// Add the ad view to your activity layout
        adContainer.addView(adView);
// Request an ad
        adView.loadAd();


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
        updateWatchInterface();
    }
    private void settime(long millissecond){
        mStartTimeINMillis =millissecond;
        resetTimer();
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
                updateWatchInterface();
                Intent intent=new Intent(CobraStretch_rest_activity.this,
                        ReverseCrunches_Ready_togo_activity.class);
                startActivity(intent);
                finish();
            }
        }.start();
        mtimerRunning=true;
        updateWatchInterface();

    }
    private void resetTimer(){
        mTimerleftInMilles= mStartTimeINMillis;
        updateCountDownTExt();
        updateWatchInterface();
    }
    private void updateCountDownTExt() {
        int hour=(int) (mTimerleftInMilles/1000)/3600;
        int minute=(int) ((mTimerleftInMilles/1000)%3600)/60;
        int second=(int) (mTimerleftInMilles/1000)%60;
        String timeLeftFormatted;
        if (hour>0){
            timeLeftFormatted=String.format(Locale.getDefault(),"%d:%02d:%02d",hour,minute,second);
        }else
        {
            timeLeftFormatted=String.format(Locale.getDefault(),"%d:%02d:%02d",hour,minute,second);
        }

        mTextviewcountdown.setText(timeLeftFormatted);
    }


    // ye niche code me rotate screen k liye lika he

    private void updateWatchInterface(){
        if (mtimerRunning){
            mEditTextInput.setVisibility(View.INVISIBLE);
            mButonset.setVisibility(View.INVISIBLE);
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonstartpause.setText("Pasue");
        }else
        {
            mButtonstartpause.setText("Start");
            mEditTextInput.setVisibility(View.VISIBLE);
            mButonset.setVisibility(View.VISIBLE);
            if (mTimerleftInMilles<1000){
                mButtonstartpause.setVisibility(View.INVISIBLE);
            }else {
                mButtonstartpause.setVisibility(View.VISIBLE);
            }
            if (mTimerleftInMilles< mStartTimeINMillis){
                mButtonReset.setVisibility(View.VISIBLE);
            }else
            {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("millisLeft", mTimerleftInMilles);
        outState.putBoolean("timerRunning", mtimerRunning);
        outState.putLong("endTime", mEndTime);
    }
    public void mButtonSet(){
        mButonset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input =mEditTextInput.getText().toString();
                if (input.length()==0){
                    Toast.makeText(CobraStretch_rest_activity.this, "Field can;t be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                long millisInput=Long.parseLong(input)*60000;
                if (millisInput==0){
                    Toast.makeText(CobraStretch_rest_activity.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                    return;
                }
                settime(millisInput);
                mEditTextInput.setText("");
            }
        });

    }
    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences prefs= CobraStretch_rest_activity.this.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putLong("starttimeInMillis",mTimerleftInMilles);
        editor.putLong("millisLeft",mTimerleftInMilles);
        editor.putBoolean("timerRunning",mtimerRunning);
        editor.putLong("endTime",mEndTime);
        editor.apply();

        if (mcountdowntimer!=null){
            mcountdowntimer.cancel();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences prefs= CobraStretch_rest_activity.this.getSharedPreferences("prefs",MODE_PRIVATE);
        mStartTimeINMillis=prefs.getLong("starttimeInMillis",30000);
        mTimerleftInMilles=prefs.getLong("millisLeft",mStartTimeINMillis);
        mtimerRunning=prefs.getBoolean("timerRunning",false);
        updateCountDownTExt();
        updateWatchInterface();
        if (mTimerleftInMilles<0){
            mTimerleftInMilles=0;
            mtimerRunning=false;
            updateCountDownTExt();
            updateWatchInterface();
        }else
        {

        }

    }
    private void NextACtivity_btn(){
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CobraStretch_rest_activity.this,
                        ReverseCrunches_Ready_togo_activity.class);
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
                        CobraStretch_rest_activity.super.onBackPressed();
                        Intent intent=new Intent(CobraStretch_rest_activity.this,
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