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

import com.fitnessapps.workoutapps.BegginnerLevel.fragment.ExcerciseActivity.All_Day_Excercise.DayEight;
import com.fitnessapps.workoutapps.R;

public class DayEightExcercise extends Fragment {

    private ProgressBar circular_pro;
    private Button dayeight;
    private TextView status;

    private int progressStatus=0;
    private Handler handler=new Handler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day_eight_excercise, container, false);

        circular_pro = view.findViewById(R.id.btnone_progressbar);
        dayeight = view.findViewById(R.id.diet_dayeight);
        status = view.findViewById(R.id.btnOne_progressstatus);
        dayeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), DayEight.class);
                startActivity(intent);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus += 10;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    circular_pro.setProgress(progressStatus);
                                    status.setText(progressStatus + "%");
                                }
                            });
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
        return view;
    }}