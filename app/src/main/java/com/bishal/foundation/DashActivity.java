package com.bishal.foundation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        CardView meditaion,sleep,nature,instruments,relax,binaural,urban,bass,noise;
        ImageView dash_menu_imgView;
        TextView dash_item1_text,dash_item2_text,dash_item3_text,dash_item4_text,dash_item5_text,dash_item6_text,dash_item7_text,dash_item8_text,dash_item9_text;

        dash_item1_text=findViewById(R.id.dash_item1_text);
        dash_item2_text=findViewById(R.id.dash_item2_text);
        dash_item3_text=findViewById(R.id.dash_item3_text);
        dash_item4_text=findViewById(R.id.dash_item4_text);
        dash_item5_text=findViewById(R.id.dash_item5_text);
        dash_item6_text=findViewById(R.id.dash_item6_text);
        dash_item7_text=findViewById(R.id.dash_item7_text);
        dash_item8_text=findViewById(R.id.dash_item8_text);
        dash_item9_text=findViewById(R.id.dash_item9_text);

        meditaion=findViewById(R.id.meditation_CView_alt);
        sleep=findViewById(R.id.sleep_CView_alt);
        nature=findViewById(R.id.nature_CView_alt);
        instruments=findViewById(R.id.instruments_CView_alt);
        relax=findViewById(R.id.relax_CView_alt);
        binaural=findViewById(R.id.binaural_CView_alt);
        urban=findViewById(R.id.urban_CView_alt);
        bass=findViewById(R.id.bass_CView_alt);
        noise=findViewById(R.id.noise_CView_alt);

        dash_menu_imgView=findViewById(R.id.dash_menu_imgView);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.custom_toast_layout));


        final Toast custom_toast=new Toast(getApplicationContext());
        custom_toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        custom_toast.setDuration(Toast.LENGTH_SHORT);
        custom_toast.setView(layout);

        dash_menu_imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(DashActivity.this, MenuActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                finish();}
        });





        meditaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                meditaion.setBackgroundColor(Color.GREEN);
                dash_item1_text.setTextColor(getResources().getColor(R.color.custom_mode_select));//change color to green when clicked


//                Toast.makeText(getApplicationContext(),"Use Headphones for Better Experience",Toast.LENGTH_SHORT).show();
                custom_toast.show(); //custom toast
                Handler handler = new Handler(); //toast custom duration
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom_toast.cancel();
                    }
                }, 1000);
                Intent i = new Intent(DashActivity.this, MeditationActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                dash_item1_text.setTextColor(getResources().getColor(R.color.white));
                finish();}
        });
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dash_item2_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                //                Toast.makeText(getApplicationContext(),"Use Headphones for Better Experience",Toast.LENGTH_SHORT).show();
                custom_toast.show(); //custom toast
                Handler handler = new Handler(); //toast custom duration
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom_toast.cancel();
                    }
                }, 1000);

                Intent i = new Intent(DashActivity.this, SleepActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                dash_item2_text.setTextColor(getResources().getColor(R.color.white));
                finish();}
        });
        nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dash_item3_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                //                Toast.makeText(getApplicationContext(),"Use Headphones for Better Experience",Toast.LENGTH_SHORT).show();
                custom_toast.show(); //custom toast
                Handler handler = new Handler(); //toast custom duration
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom_toast.cancel();
                    }
                }, 1000);
                Intent i = new Intent(DashActivity.this, NatureActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                dash_item3_text.setTextColor(getResources().getColor(R.color.white));
                finish();}
        });
        instruments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dash_item4_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                //                Toast.makeText(getApplicationContext(),"Use Headphones for Better Experience",Toast.LENGTH_SHORT).show();
                custom_toast.show(); //custom toast
                Handler handler = new Handler(); //toast custom duration
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom_toast.cancel();
                    }
                }, 1000);
                Intent i = new Intent(DashActivity.this, InstrumentsActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                dash_item4_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                finish();}
        });
        relax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dash_item5_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                //                Toast.makeText(getApplicationContext(),"Use Headphones for Better Experience",Toast.LENGTH_SHORT).show();
                custom_toast.show(); //custom toast
                Handler handler = new Handler(); //toast custom duration
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom_toast.cancel();
                    }
                }, 1000);
                Intent i = new Intent(DashActivity.this, RelaxActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                dash_item5_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                finish();}
        });
        binaural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dash_item6_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                //                Toast.makeText(getApplicationContext(),"Use Headphones for Better Experience",Toast.LENGTH_SHORT).show();
                custom_toast.show(); //custom toast
                Handler handler = new Handler(); //toast custom duration
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom_toast.cancel();
                    }
                }, 1000);
                Intent i = new Intent(DashActivity.this, BinauralActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                dash_item6_text.setTextColor(getResources().getColor(R.color.white));

                finish();}
        });
        urban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dash_item7_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                //                Toast.makeText(getApplicationContext(),"Use Headphones for Better Experience",Toast.LENGTH_SHORT).show();
                custom_toast.show(); //custom toast
                Handler handler = new Handler(); //toast custom duration
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom_toast.cancel();
                    }
                }, 1000);
                Intent i = new Intent(DashActivity.this, UrbanActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                dash_item7_text.setTextColor(getResources().getColor(R.color.white));
                finish();}
        });
        bass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dash_item8_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                //                Toast.makeText(getApplicationContext(),"Use Headphones for Better Experience",Toast.LENGTH_SHORT).show();
                custom_toast.show(); //custom toast
                Handler handler = new Handler(); //toast custom duration
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom_toast.cancel();
                    }
                }, 1000);
                Intent i = new Intent(DashActivity.this, BassActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                dash_item8_text.setTextColor(getResources().getColor(R.color.white));
                finish();}
        });
        noise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dash_item9_text.setTextColor(getResources().getColor(R.color.custom_mode_select));
                //                Toast.makeText(getApplicationContext(),"Use Headphones for Better Experience",Toast.LENGTH_SHORT).show();
                custom_toast.show(); //custom toast
                Handler handler = new Handler(); //toast custom duration
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom_toast.cancel();
                    }
                }, 1000);
                Intent i = new Intent(DashActivity.this, NoiseActivity.class);
                startActivity(i);
            }
            public void onBackPressed(){
                dash_item9_text.setTextColor(getResources().getColor(R.color.white));
                finish();}
        });


    }
}
