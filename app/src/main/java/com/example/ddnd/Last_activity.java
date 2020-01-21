package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Last_activity extends AppCompatActivity {

//    Button btnSubmit;
//    TextView tvReview, tvPercentage;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_last_activity);
//        getSupportActionBar().setTitle("Result Screen");
//        btnSubmit = findViewById(R.id.btnSubmit);
//
//        Intent intentThatStartedThis = getIntent();
//        int Score = intentThatStartedThis.getIntExtra("score", 0);
////        tvResult.setText(String.valueOf(result));
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Last_activity.this , MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }

    Button btnSubmit;
    TextView tvReview, tvPercentage;
    int PerStart, PerEnd;
    int Score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_activity);
        getSupportActionBar().setTitle("Results");
        btnSubmit = findViewById(R.id.btnSubmit);
        tvPercentage = findViewById(R.id.tvPercentage);
        tvReview = findViewById(R.id.tvReview);

        Intent intentThatStartedThis = getIntent();
        Score = intentThatStartedThis.getIntExtra("score", 0);

//        tvResult.setText(String.valueOf(result));

        calcResult();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Last_activity.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calcResult(){

        if(Score > 10)
        {
            PerStart = 0;
            PerEnd = 5;
        }
        else if (Score == 9)
        {
            PerStart = 5;
            PerEnd = 6;
//            perShow(Score,PerStart,PerEnd);
        }
        else if (Score == 7)
        {
            PerStart = 8;
            PerEnd = 10;
//            perShow(Score,PerStart,PerEnd);
        }
        else if (Score == 6)
        {
            PerStart = 12;
            PerEnd = 16;
//            perShow(Score,PerStart,PerEnd);
        }
        else if (Score == 5)
        {
            PerStart = 15;
            PerEnd = 20;
//            perShow(Score,PerStart,PerEnd);
        }
        else if (Score == 4)
        {
            PerStart = 20;
            PerEnd = 29;
//            perShow(Score,PerStart,PerEnd);
        }
        else if (Score == 3)
        {
            PerStart = 25;
            PerEnd = 32;
//            perShow(Score,PerStart,PerEnd);
        }
        else if(Score ==2){
            PerStart = 33;
            PerEnd = 38;
        }
        else{
            PerStart = 40;
            PerEnd = 50;
        }

        perShow(Score,PerStart,PerEnd);


    }


    public void perShow(int score, int  PerStart, int PerEnd)
    {
        Toast.makeText(Last_activity.this , "pershow called" , Toast.LENGTH_SHORT).show();

        if(score < 4)
        {
            tvPercentage.setText(PerStart + "" + " - " + PerEnd + " %");
            tvReview.setText(" Profound ");
        }
        else if(score >= 4 && score < 5)
        {
            tvPercentage.setText(PerStart + "" + " - " + PerEnd + " %");
            tvReview.setText("Critical");
        }
        else if(score >= 6 && score < 7)
        {
            tvPercentage.setText(PerStart + "" + " - " + PerEnd + " %");
            tvReview.setText("Moderate");
        }
        else if(score >= 7 && score < 9)
        {
            tvPercentage.setText(PerStart + "" + " - " + PerEnd + " %");
            tvReview.setText("Mild");
        }
        else
        {
            tvPercentage.setText(PerStart + "" + " - " + PerEnd + " %");
            tvReview.setText("Normal");
        }
    }
}
