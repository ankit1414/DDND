package com.example.ddnd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button play,about,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button connections
        play = findViewById(R.id.play_button);
        about= findViewById(R.id.about_button);
        exit = findViewById(R.id.exit_button);


// button click handlings
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.super.onBackPressed();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "about",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                View myview = layoutInflater.inflate(R.layout.about,null);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setView(myview);
                alertDialog.show();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "play",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this , Play_activity.class);
                startActivity(intent);
            }
        });

    }
}
