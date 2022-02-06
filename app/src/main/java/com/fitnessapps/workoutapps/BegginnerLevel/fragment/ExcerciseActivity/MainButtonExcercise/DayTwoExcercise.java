package com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.MainButtonExcercise;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayTwo;
import com.fitnessapps.workoutapps.R;


public class DayTwoExcercise extends Fragment {

    private ProgressBar circular_pro;
    private Button daytwo;
    private TextView status;

    private int progressStatus=0;
    private Handler handler=new Handler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_day_two_excercise, container, false);

        circular_pro=view.findViewById(R.id.btnone_progressbar);
        daytwo=view.findViewById(R.id.diet_daytwo);
        status=view.findViewById(R.id.btnOne_progressstatus);
        daytwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),DayTwo.class);
                startActivity(intent);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus<100){
                            progressStatus+=10;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    circular_pro.setProgress(progressStatus);
                                    status.setText(progressStatus+"%");
                                }
                            });
                            try {
                                Thread.sleep(200);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
        return view;
    }
}