package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Play_activity extends AppCompatActivity {
    private ArrayList<String> questions = new ArrayList<>();
    private int i=0;

    private TextView question_tv,dontremember;
    private EditText answer_et;
    private Button next_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_activity);
        getSupportActionBar().setTitle("Basic questions");
        createQuestions();
        // findview by ids
        question_tv = findViewById(R.id.ques_textview);
        answer_et = findViewById(R.id.ans_edittext);
        next_button = findViewById(R.id.next_button);
        dontremember = findViewById(R.id.dontRemember_tv);

        // click event handlings

        dontremember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Play_activity.this , "skip clicked" , Toast.LENGTH_SHORT).show();
                next_button.callOnClick();
            }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(i == questions.size()-1)){
                    question_tv.setText(questions.get(++i));
                    if(i ==questions.size()-1){
                        next_button.setText("submit");
                    }
                }
//                else{
//                    Intent intent = new Intent(Play_activity.this , Quiz_activity.class);
//                    startActivity(intent);
//                    finish();
//                }
                  else{
                    Intent intent = new Intent(Play_activity.this , animal_count.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    public void createQuestions(){
        questions.add("What is your name?");
        questions.add("What date is today?");
        questions.add("What day is today?");
        questions.add("Which season is this?");
        questions.add("Which city you are in?");
    }
}
