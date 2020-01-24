package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Before_dogs extends AppCompatActivity {
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_dogs);
        getSupportActionBar().setTitle("Information");
        score = getIntent().getIntExtra("score" , 0);
//        Toast.makeText(getApplicationContext(),"score =" +score ,Toast.LENGTH_SHORT).show();
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Before_dogs.this , Dog_second.class);
                intent.putExtra("score",score);
                startActivity(intent);
                finish();
            }
        });

    }
}
