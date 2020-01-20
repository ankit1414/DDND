package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Play_activity extends AppCompatActivity {
    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();
    private int i=0;
    int score =0;
    boolean skip = false;

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
                //Toast.makeText(Play_activity.this , "skip clicked" , Toast.LENGTH_SHORT).show();
                skip = true;
                next_button.callOnClick();
            }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answer_et.getText().toString().isEmpty() || skip == true){
                    skip = false;
                    if(!(i == questions.size()-1)){
                        String ans = answer_et.getText().toString().trim();
                        answers.add(ans);
                        answer_et.setText("");
                        question_tv.setText(questions.get(++i));
                        if(i ==questions.size()-1){
                            next_button.setText("submit");
                        }
                    }
                    else{
                        String ans = answer_et.getText().toString().trim();
                        answers.add(ans);
                        handleResponses();
                        Toast.makeText(Play_activity.this , "score = "+score , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Play_activity.this , Quiz_activity.class);
                        startActivity(intent);
                        finish();
                    }


                }
            }
        });
       
    }
    public void createQuestions(){
        questions.add("What is your name?");
        questions.add("What date is today?");
        questions.add("What day is today?");
//        questions.add("Which season is this?");
//        questions.add("Which city you are in?");
    }
    private void handleResponses(){
        if(!answers.get(0).equals(""))
            score++;

        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        if(answers.get(1).equals(currentDate))
            score++;

        String dayOfTheWeek = new SimpleDateFormat("EEEE").format(new Date());

        if(answers.get(2).equalsIgnoreCase(dayOfTheWeek))
            score++;

    }

}
