package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.ALL_DAY_FOLDER.daytwo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.ads.AdView;
import com.fitnessapps.workoutapps.MainActivity;
import com.fitnessapps.workoutapps.R;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class Bike_pushup_ready_togo extends AppCompatActivity {


    CircularView circularViewWithTimer;
    TextView textView;
    MediaPlayer mediaPlayer;
    private AdView fbadview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_pushup_ready_togo);

        circularViewWithTimer = findViewById(R.id.circular_view);
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(10)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

//                                 Will be called if times up of countdown timer

                                Intent intent=new Intent(Bike_pushup_ready_togo.this,
                                        Bike_push_StartExercise.class);
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
                        Bike_pushup_ready_togo.super.onBackPressed();
                        Intent intent=new Intent(Bike_pushup_ready_togo.this,
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

}