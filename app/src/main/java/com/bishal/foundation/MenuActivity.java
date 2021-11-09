package com.bishal.foundation;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;


public class MenuActivity extends AppCompatActivity {

    TextView menu_title_text,theme_textview;
    Animation text_bounce_animation;
    CardView rate_cardview,help_cardview,feedback_cardview,about_cardview,theme_cardview,donate_cardview,share_cardview,account_cardview;
    ToggleButton dark_day_toggle;
    Uri uri;


    private AlertDialog.Builder builder;
    private AlertDialog custom_dialog;

    public void DarkModeOn(View view){

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);


    }
    public void DarkModeOff(View view){

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }

    public void createNewAlertDialog1(){ //about popup dialogue
        builder=new AlertDialog.Builder(this);
        final View aboutPopUp= getLayoutInflater().inflate(R.layout.custom_toast2,null);
        builder.setView(aboutPopUp);
        custom_dialog=builder.create();
        custom_dialog.show();
    }
    public void createNewAlertDialog2(){ //help popup dialogue
        builder=new AlertDialog.Builder(this);
        final View aboutPopUp= getLayoutInflater().inflate(R.layout.custom_help,null);
        builder.setView(aboutPopUp);
        custom_dialog=builder.create();
        custom_dialog.show();
    }
    public void createNewAlertDialog3(){ //donate popup dialogue
        builder=new AlertDialog.Builder(this);
        final View aboutPopUp= getLayoutInflater().inflate(R.layout.custom_donate,null);
        builder.setView(aboutPopUp);
        custom_dialog=builder.create();
        custom_dialog.show();
    }

    public void onClickInstagram(View view){
            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/_bishal_08/"));
            startActivity(viewIntent);
    }
    public void onClickFacebook(View view){
        Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/bishal.chatterjee.7946"));
        startActivity(viewIntent);
    }
    public void onClickLinkedIn(View view){
        Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.linkedin.com/in/bishal-chatterjee-03304721b"));
        startActivity(viewIntent);
    }
    public void onClickGitHub(View view){
        Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/bishalchatterjee"));
        startActivity(viewIntent);
    }
    public void onClickEmail(View view){ //to copy email to clipboard
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Email", "bishalc430@gmail.com");
        clipboard.setPrimaryClip(clip);

        Toast.makeText(MenuActivity.this, "Email Copied to Clipboard", Toast.LENGTH_LONG).show();

    }
    public void onClickNumber(View view){//to copy number to clipboard
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Contact Number", "+91 7478566042");
        clipboard.setPrimaryClip(clip);

        Toast.makeText(MenuActivity.this, "Contact Number Copied to Clipboard", Toast.LENGTH_LONG).show();

    }
    public void onClickUPI(View view){//to copy number to clipboard
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("UPI ID", "bishalc430@oksbi");
        clipboard.setPrimaryClip(clip);

        Toast.makeText(MenuActivity.this, "UPI ID Copied to Clipboard", Toast.LENGTH_LONG).show();

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        menu_title_text=findViewById(R.id.menu_title_text);
        text_bounce_animation = AnimationUtils.loadAnimation(this, R.anim.interpolator_anim);


        rate_cardview=findViewById(R.id.rate_cardview);
        about_cardview=findViewById(R.id.about_cardview);
        help_cardview=findViewById(R.id.help_cardview);
        feedback_cardview=findViewById(R.id.feedback_cardview);
        theme_cardview=findViewById(R.id.theme_cardview);
        donate_cardview=findViewById(R.id.donate_cardview);
        share_cardview=findViewById(R.id.share_cardview);
        account_cardview=findViewById(R.id.account_cardview);




        theme_textview = findViewById(R.id.theme_textview);

        dark_day_toggle=findViewById(R.id.dark_day_toggle);





        rate_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_title_text.startAnimation(text_bounce_animation);
                uri = Uri.parse("market://details?id=$packageName");   //will add the app link when its live on play store
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://play.google.com/store/apps/details?id=$packageName")));
                }

            }
            public void onBackPressed(){
                finish();}
        });
        about_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_title_text.startAnimation(text_bounce_animation);

               createNewAlertDialog1();//pop up about

            }
            public void onBackPressed(){
                custom_dialog.dismiss();
                finish();}
        });
        help_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_title_text.startAnimation(text_bounce_animation);
                createNewAlertDialog2();//pop up help
            }
            public void onBackPressed(){
                finish();}
        });
        feedback_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_title_text.startAnimation(text_bounce_animation);

                //redirect to feedback activity
                Intent i = new Intent(MenuActivity.this, FeedbackActivity.class);
                startActivity(i);

            }
            public void onBackPressed(){
                finish();}
        });
        theme_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_title_text.startAnimation(text_bounce_animation);
                Toast.makeText(getApplicationContext(),"Tap The Toggle Icon To Change The Theme",Toast.LENGTH_SHORT).show();
            }
            public void onBackPressed(){
                finish();}
        });
        dark_day_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_title_text.startAnimation(text_bounce_animation);
                if(dark_day_toggle.isChecked())
                {
                    theme_textview.setText("     Theme  -  Dark Theme");
                    DarkModeOn(view);

                }
                else {
                    theme_textview.setText("     Theme  -  Day Theme");
                    DarkModeOff(view);
                }

            }
            public void onBackPressed(){
                finish();}
        });
        donate_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_title_text.startAnimation(text_bounce_animation);

                createNewAlertDialog3();//donate pop up
            }
            public void onBackPressed(){
                finish();}
        });
        share_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_title_text.startAnimation(text_bounce_animation);


                //share app to other apps
                //using sendIntent

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey Check Out This App At: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }

            public void onBackPressed(){
                finish();}
        });


        account_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_title_text.startAnimation(text_bounce_animation);
                Intent i = new Intent(MenuActivity.this,GoogleActivity.class);
                startActivity(i);

            }

            public void onBackPressed(){
                finish();}
        });

    }
}