package com.example.ddnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Dog_second extends AppCompatActivity {

    Button btnStaggy, btnBruno, btnMars, btnMax;
    ImageView ivContainer;
    int Score = 0, imageNo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_second);

        btnBruno = findViewById(R.id.btnBruno);
        btnMars = findViewById(R.id.btnMars);
        btnMax = findViewById(R.id.btnMax);
        btnStaggy = findViewById(R.id.btnStaggy);
        ivContainer = findViewById(R.id.ivContainer);

        btnStaggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageNo == 0){
                    Score++;
                }
                changeImage(imageNo);
            }
        });
        btnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageNo == 1)
                {
                    Score++;
                }
                changeImage(imageNo);
            }
        });
        btnMars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageNo == 2)
                {
                    Score++;
                }
                changeImage(imageNo);
            }

        });
        btnBruno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageNo == 3)
                {
                    Score++;
                }
                changeImage(imageNo);
            }
        });
    }
    public void changeImage(int image)
    {
        if(image == 0)
        {
            ivContainer.setImageResource(R.drawable.max);
//            Toast.makeText(this, "Score: "+Score, Toast.LENGTH_SHORT).show();
            imageNo++;
            return;
        }
        else if(image == 1)
        {
            ivContainer.setImageResource(R.drawable.mars);
            imageNo++;
            return;
        }
        else if(image == 2)
        {
            ivContainer.setImageResource(R.drawable.bruno);
            imageNo++;
            return;
        }
        else
        {
//            Toast.makeText(this, "Score: "+Score, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Dog_second.this, Last_activity.class);
            i.putExtra("Score", Score);
            startActivity(i);

        }
    }
}
