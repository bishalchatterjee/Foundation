package com.bishal.foundation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class GoogleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);

        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView LoggedInCheck = findViewById(R.id.google_user_login_status);
        ImageView LoggedInOrOutImg=findViewById(R.id.google_user_log_in_out_img);
        final TextView email = findViewById(R.id.google_user_gmail);
        final TextView username = findViewById(R.id.google_user_gmail_name);
        final Button logout_btn = findViewById(R.id.logout_btn);
        final Button login_btn = findViewById(R.id.login_btn);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);


        if (googleSignInAccount != null) {
            final String getUsername = googleSignInAccount.getDisplayName();
            final String getGmail = googleSignInAccount.getEmail();

            email.setText("Gmail- " + getGmail);
            username.setText("Name- " + getUsername);

            // if user is logged in we need to hide the log in button & display log out only since both button are overlapping
            login_btn.setVisibility(View.GONE);
            login_btn.setEnabled(false);


            logout_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    googleSignInClient.signOut();
                    startActivity(new Intent(GoogleActivity.this, FeaturesActivity.class));
                    finish();
                }
            });
        }
        else{
            LoggedInCheck.setText("NOT LOGGED IN !");
            email.setText("");
            username.setText("");
            LoggedInOrOutImg.setImageResource(R.drawable.google_loggedout);
            // to re enable the buttons
            logout_btn.setVisibility(View.GONE);
            login_btn.setVisibility(View.VISIBLE);
            login_btn.setEnabled(true);

            login_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    googleSignInClient.signOut();
                    startActivity(new Intent(GoogleActivity.this, FeaturesActivity.class));
                    finish();
                }
            });


        }
    }
}