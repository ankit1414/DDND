package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ddnd.data.ClockTimeData;

import java.util.ArrayList;

public class ClockTimeActivity extends AppCompatActivity {

    private ArrayList<ClockTimeData> clocktimeArray;
    private int index =0;

    private int score =0;

    private ImageView imageView;
    private EditText response;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_time);
        getSupportActionBar().setTitle("Clock Time Round");
        getIntent().getIntExtra("score" , 0);
        imageView = findViewById(R.id.clock_image);
        response = findViewById(R.id.time_editText);
        submit = findViewById(R.id.submit_time);




        generateDataArray();
        setResources(index++);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!response.getText().toString().isEmpty()){
                    if(index<clocktimeArray.size()){
                        checkResult(index);
                        response.setText("");
                        setResources(index++);
                    }
                    else{
                        index--;
                        checkResult(index);
                        Intent intent = new Intent(ClockTimeActivity.this ,Quiz_activity.class);
                        intent.putExtra("score" , score);
                        startActivity(intent);
                        finish();
                    }

                }
            }
        });


    }

    private void checkResult(int i){
        i--;
        if(response.getText().toString().equals(clocktimeArray.get(i).getTime())){
            score++;
            Toast.makeText(getApplicationContext() , "correct" , Toast.LENGTH_SHORT).show();
        }
    }

    private void setResources(int i){
        imageView.setImageResource(clocktimeArray.get(i).getImageRes());
    }


    private void generateDataArray(){
        clocktimeArray = new ArrayList<>();
        clocktimeArray.add(new ClockTimeData(R.drawable.clockquestion,"01:15"));
        clocktimeArray.add(new ClockTimeData(R.drawable.clocksecond,"01:47"));
    }
}
