package com.fitnessapps.workoutapps.AdvanceExcercise.Advance_excercise_fragment.abc_workout_excercise.ABC;

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

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

import java.util.Locale;

public class Reverse_rest extends AppCompatActivity {

    private EditText mEditTextInput;
    private Button mButonset;
    private TextView mTextviewcountdown,nextbtn;
    private Button mButtonstartpause, mButtonReset;
    private CountDownTimer mcountdowntimer;
    private boolean mtimerRunning;
    private long mStartTimeINMillis;
    private long mTimerleftInMilles = mStartTimeINMillis;
    private long mEndTime;
    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_rest);
        mTextviewcountdown = findViewById(R.id.reset_textview_countdown);
        mButtonstartpause = findViewById(R.id.rest_mountainclimber_start);
        mButtonReset = findViewById(R.id.rest_mountainclimber_reset);
        mEditTextInput=findViewById(R.id.edit_text_input);
        mButonset=findViewById(R.id.button_set);
        nextbtn=findViewById(R.id.dayone_rest_nextbtn);
        PasueButton();
        RestartButton();
        mButtonSet();
        NextACtivity_btn();


        adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), AdSize.BANNER_HEIGHT_50);
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
                Intent intent=new Intent(Reverse_rest.this,
                        Reverse_crunch_ready_togo.class);
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
                    Toast.makeText(Reverse_rest.this, "Field can;t be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                long millisInput=Long.parseLong(input)*60000;
                if (millisInput==0){
                    Toast.makeText(Reverse_rest.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
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
        SharedPreferences prefs= Reverse_rest.this.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
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
        SharedPreferences prefs= Reverse_rest.this.getSharedPreferences("prefs",MODE_PRIVATE);
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
                Intent intent=new Intent(Reverse_rest.this,
                        Reverse_crunch_ready_togo.class);
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
                        Reverse_rest.super.onBackPressed();
                        Intent intent=new Intent(Reverse_rest.this,
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
}