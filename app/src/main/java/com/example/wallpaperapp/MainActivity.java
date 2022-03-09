package com.example.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button btn_lockscreen, btn_homescreen, btn_both;
    private RadioButton radioButton;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_lockscreen = findViewById(R.id.btn_lockscreen);
        btn_homescreen = findViewById(R.id.btn_homescreen);
        btn_both = findViewById(R.id.btn_both);
        radioGroup = findViewById(R.id.radioGroup);


        WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());


        btn_homescreen.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);
                try {


                    if (radioID == R.id.radio0) {
                        myWallpaperManager.setResource(R.drawable.astronaut);
                    } else if (radioID == R.id.radio1) {
                        myWallpaperManager.setResource(R.drawable.deer);
                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        });

        btn_lockscreen.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);
                try {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                        if (radioID == R.id.radio0) {

                            myWallpaperManager.setResource(R.drawable.astronaut, myWallpaperManager.FLAG_LOCK);
                        } else if (radioID == R.id.radio1) {
                            myWallpaperManager.setResource(R.drawable.deer, myWallpaperManager.FLAG_LOCK);
                        }
                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        });

        btn_both.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);

                try {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {


                        if (radioID == R.id.radio0) {
                            myWallpaperManager.setResource(R.drawable.astronaut, myWallpaperManager.FLAG_LOCK);
                            myWallpaperManager.setResource(R.drawable.astronaut);
                        } else if (radioID == R.id.radio1) {
                            myWallpaperManager.setResource(R.drawable.deer, myWallpaperManager.FLAG_LOCK);
                            myWallpaperManager.setResource(R.drawable.deer);
                        }


                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
        });


    }


}