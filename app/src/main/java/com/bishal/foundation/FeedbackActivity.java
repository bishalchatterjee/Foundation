package com.bishal.foundation;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {
    EditText feedback_edit;
    Button copy_btn;
    ImageButton send_btn;
    public void onClickFeedBack(View view){

        Intent feedbackEmail = new Intent(Intent.ACTION_SEND);

        feedbackEmail.setType("text/email");
        feedbackEmail.putExtra(Intent.EXTRA_EMAIL, new String[] {"bishalc430@gmail.com"});
        feedbackEmail.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        feedbackEmail.putExtra(Intent.EXTRA_TEXT,feedback_edit.getText().toString());
        startActivity(Intent.createChooser(feedbackEmail, "Send Feedback:"));
    }

    public void onClickFeedBack_info(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_spam_alert,(ViewGroup)findViewById(R.id.custom_spam_alert));


        final Toast custom_toast=new Toast(getApplicationContext());
        custom_toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        custom_toast.setDuration(Toast.LENGTH_SHORT);
        custom_toast.setView(layout);

        custom_toast.show();
        Handler handler = new Handler(); //toast custom duration
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                custom_toast.cancel();
            }
        }, 1500);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        feedback_edit=findViewById(R.id.feedback_edit);
        copy_btn=findViewById(R.id.copy_btn);
        send_btn=findViewById(R.id.send_btn);





        copy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String typed_string= feedback_edit.getText().toString();

                if(typed_string!=null){
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("USER FEEDBACK TYPED",typed_string);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(FeedbackActivity.this, "Feedback Copied to Clipboard !", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(FeedbackActivity.this, "Feedback Cant Be Empty !", Toast.LENGTH_LONG).show();

                }
            }
            public void onBackPressed(){
                finish();}
        });
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onClickFeedBack(view);
            }
            public void onBackPressed(){
                finish();}
        });
    }
}