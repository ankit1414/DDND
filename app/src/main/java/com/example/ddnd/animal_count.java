package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class animal_count extends AppCompatActivity {

    CircularView circularViewWithTimer;
    TextView tvTotal;
    Button btnAdd, btnStart, btnStop ,btnSubmit;
    boolean flag = false;
    int score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_count);
        getSupportActionBar().setTitle("Timer Round");
        score = getIntent().getIntExtra("score",0);
        Toast.makeText(getApplicationContext(),"score =" +score ,Toast.LENGTH_SHORT).show();
        tvTotal = findViewById(R.id.tvTotal);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubmit = findViewById(R.id.btnSubmit);
//        etAnswer = findViewById(R.id.etAnswer);
        circularViewWithTimer = findViewById(R.id.circular_view);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circularViewWithTimer.startTimer();
                flag = true;
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circularViewWithTimer.stopTimer();
                flag = false;
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circularViewWithTimer.stopTimer();
                Intent intent = new Intent(animal_count.this , ClockImage .class);
                calcScore();
                intent.putExtra("score" , score);
                startActivity(intent);
                finish();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){
                int current = Integer.parseInt(tvTotal.getText().toString());
                current++;
                tvTotal.setText(current+"");
            }}
        });


        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(179)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

                                // Will be called if times up of countdown timer
                                Toast.makeText(animal_count.this, "Time up! ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onTimerCancelled() {

                                // Will be called if stopTimer is called
                                Toast.makeText(animal_count.this, "Timer Stopped! ", Toast.LENGTH_SHORT).show();
                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);

    }
    private  void calcScore(){
        int temp = Integer.parseInt(tvTotal.getText().toString());
        if(temp>9 && temp<21)
            score++;
        else if(temp>20)
            score+=2;

    }

}
