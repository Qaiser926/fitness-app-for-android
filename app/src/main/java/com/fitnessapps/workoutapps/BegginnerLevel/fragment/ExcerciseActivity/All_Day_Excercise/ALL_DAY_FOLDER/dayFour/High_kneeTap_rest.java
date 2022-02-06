package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.dayFour;

import androidx.annotation.NonNull;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

import java.util.Locale;

public class High_kneeTap_rest extends AppCompatActivity {


    private EditText mEditTextInput;
    private Button mButonset;
    private TextView mTextviewcountdown,nextbtn;
    private Button mButtonstartpause, mButtonReset;
    private CountDownTimer mcountdowntimer;
    private boolean mtimerRunning;
    private long mStartTimeINMillis;
    private long mTimerleftInMilles = mStartTimeINMillis;
    private long mEndTime;
    AdView admobAdview;
    InterstitialAd admobInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_knee_tap_rest);
        mTextviewcountdown = findViewById(R.id.reset_textview_countdown);
        mButtonstartpause = findViewById(R.id.rest_mountainclimber_start);
        mButtonReset = findViewById(R.id.rest_mountainclimber_reset);
        mEditTextInput=findViewById(R.id.edit_text_input);
        mButonset=findViewById(R.id.button_set);
        nextbtn=findViewById(R.id.dayone_rest_nextbtn);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdmobbannerAds();
        SetadmobInterstitialAds();
        PasueButton();
        RestartButton();
        mButtonSet();
        NextACtivity_btn();

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
//                Intent intent=new Intent(DayOne_RestActivity.this, Dayone_squat_RestActivity.class);
//                startActivity(intent);
//                finish();
//                Toast.makeText(DayOne_RestActivity.this, "finish Succesful", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(High_kneeTap_rest.this,
                        High_plank_jack_ready_togo.class);
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
                    Toast.makeText(High_kneeTap_rest.this, "Field can;t be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                long millisInput=Long.parseLong(input)*60000;
                if (millisInput==0){
                    Toast.makeText(High_kneeTap_rest.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
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
        SharedPreferences prefs= High_kneeTap_rest.this.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
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
        SharedPreferences prefs= High_kneeTap_rest.this.getSharedPreferences("prefs",MODE_PRIVATE);
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
//                Intent intent=new Intent(DayOne_RestActivity.this,Dayone_squat_RestActivity.class);
//                startActivity(intent);
//                finish();
//                Toast.makeText(DayOne_RestActivity.this, "next bton work seccessful", Toast.LENGTH_SHORT).show();


                if (admobInterstitialAd != null) {
                    admobInterstitialAd.show(High_kneeTap_rest.this);
                    admobInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Intent intent=new Intent(High_kneeTap_rest.this,
                                    High_plank_jack_ready_togo.class);
                            startActivity(intent);
                            finish();
                            admobInterstitialAd=null;
                            SetadmobInterstitialAds();
                        }
                    });
                } else {
                    Intent intent=new Intent(High_kneeTap_rest.this,
                            High_plank_jack_ready_togo.class);
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
                        High_kneeTap_rest.super.onBackPressed();
                        Intent intent=new Intent(High_kneeTap_rest.this,
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

}
