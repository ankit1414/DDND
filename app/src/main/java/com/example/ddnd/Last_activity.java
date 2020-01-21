package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Last_activity extends AppCompatActivity {

    Button btnSubmit;
    TextView tvReview, tvPercentage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_activity);
        getSupportActionBar().setTitle("Result Screen");
        btnSubmit = findViewById(R.id.btnSubmit);

        Intent intentThatStartedThis = getIntent();
        int Score = intentThatStartedThis.getIntExtra("score", 0);
//        tvResult.setText(String.valueOf(result));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Last_activity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
