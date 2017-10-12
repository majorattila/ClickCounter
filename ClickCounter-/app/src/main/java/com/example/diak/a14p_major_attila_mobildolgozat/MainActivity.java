package com.example.diak.a14p_major_attila_mobildolgozat;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button plusz, minusz, reset;
    private TextView eredmeny;
    private int szam = 0, clickCounter = 0;
    Toast mToastToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        plusz = (Button) findViewById(R.id.button_plusz);
        minusz = (Button) findViewById(R.id.button_minusz);
        reset = (Button) findViewById(R.id.button_reset);
        eredmeny = (TextView) findViewById(R.id.textView_eredmeny);

        plusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam += 1;
                clickCounter++;
                eredmeny.setText("" + szam);
                checkClickNumber();
            }
        });

        minusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam -= 1;
                clickCounter++;
                eredmeny.setText("" + szam);
                checkClickNumber();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam = 0;
                clickCounter++;
                eredmeny.setText("" + szam);
                checkClickNumber();
            }
        });
    }
    public void checkClickNumber(){
        if(clickCounter==20){

            // Set the toast and duration
            int toastDurationInMilliSeconds = 10000;
            mToastToShow = Toast.makeText(this, "Unatkozol?.", Toast.LENGTH_LONG);

            // Set the countdown to display the toast
            CountDownTimer toastCountDown;
            toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
                public void onTick(long millisUntilFinished) {
                    mToastToShow.show();
                }
                public void onFinish() {
                    mToastToShow.cancel();
                }
            };

            // Show the toast and starts the countdown
            mToastToShow.show();
            toastCountDown.start();
            clickCounter = 0;
        }
    }
}
