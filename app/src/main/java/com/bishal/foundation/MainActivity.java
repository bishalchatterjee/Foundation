package com.bishal.foundation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {


    //Variables
    Animation topAnim,bottomAnim;
    ImageView splash1_img;
    TextView app_name,app_slogan;
    SharedPreferences preferences;//to get preference and run the FeaturesActivity only for the first time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);




       // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Animation Link
        topAnim= AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //ImageView TextView link
        splash1_img=findViewById(R.id.splash1_img);
        app_name=findViewById(R.id.app_name);
        app_slogan=findViewById(R.id.app_slogan);


        //hooks
        splash1_img.setAnimation(topAnim);
        app_name.setAnimation(bottomAnim);
        app_slogan.setAnimation(bottomAnim);

        //splash delay function
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                preferences = getSharedPreferences("PREFERENCE",MODE_PRIVATE);//name and mode(has to be MODE_PRIVATE)
                Boolean isFirstTime = preferences.getBoolean("firstTime",true); //sets default true to firstTime variable if not present auto creates

                if(isFirstTime){//returns boolean type
                    SharedPreferences.Editor editor = preferences.edit();//edit the preference as the first time is already checked
                    editor.putBoolean("firstTime",false);
                    editor.commit(); //commit changes to firstTime

                    Intent i = new Intent(MainActivity.this, FeaturesActivity.class);
                    startActivity(i);
                    finish();

                }else {
                    Intent i = new Intent(MainActivity.this, DashActivity.class);
                    startActivity(i);
                    finish();

                }

            }
        }, 2500);

    }
}