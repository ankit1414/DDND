package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dog_first extends AppCompatActivity {
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_first);
        getSupportActionBar().setTitle("Save'em Round");
        Button proceedbtn = findViewById(R.id.proceed_button);
        proceedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = getIntent().getIntExtra("score" , 0);
                Intent intent = new Intent(Dog_first.this , ClockTimeActivity.class);
                intent.putExtra("score" , score);
                startActivity(intent);
                finish();
            }
        });
    }
}
