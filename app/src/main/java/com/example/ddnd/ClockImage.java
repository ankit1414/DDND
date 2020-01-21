package com.example.ddnd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ClockImage extends AppCompatActivity {

    Button btnCapture, btnSubmit;
    ImageView ivCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_image);

        btnCapture = findViewById(R.id.btnCapture);
        btnSubmit = findViewById(R.id.btnSubmit);
        ivCamera = findViewById(R.id.ivCamera);

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
                btnCapture.setText("Capture Again");
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap  bitmap = (Bitmap) data.getExtras().get("data");
        ivCamera.setImageBitmap(bitmap);
    }
}
