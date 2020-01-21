package com.example.ddnd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button play,about,exit;

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_res,menu);
//        return true;
//    }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.example_menu, menu);
    return true;
}


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                View myview = layoutInflater.inflate(R.layout.about,null);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setView(myview);
                alertDialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Home");
        //button connections
        play = findViewById(R.id.play_button);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);



// button click handlings
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.super.onBackPressed();
//            }
//        });
//
//        about.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(getApplicationContext(), "about",Toast.LENGTH_SHORT).show();
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
//                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
//                View myview = layoutInflater.inflate(R.layout.about,null);
//                AlertDialog alertDialog = alertDialogBuilder.create();
//                alertDialog.setView(myview);
//                alertDialog.show();
//            }
//        });

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
