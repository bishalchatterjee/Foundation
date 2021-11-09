package com.bishal.foundation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class FeaturesActivity extends AppCompatActivity {

    TextView text,app_name_animated;
    Animation app_name_animation,splash2_anim;
    ImageView splash2,google_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button getStarted_btn;
        getStarted_btn=findViewById(R.id.getStarted_btn);


        text = findViewById(R.id.splash_text);
        splash2=findViewById(R.id.splash2_img);
        app_name_animated=findViewById(R.id.app_name_animated);
        google_signin=findViewById(R.id.google_signin_img);

        app_name_animation= AnimationUtils.loadAnimation(this, R.anim.experimental_animation);
        app_name_animated.setAnimation(app_name_animation);
        splash2_anim= AnimationUtils.loadAnimation(this, R.anim.experimental_anim);
        splash2.setAnimation(splash2_anim);


        //Every moment is a fresh beginning --animation
        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setRepeatCount(Animation.INFINITE);
        out.setRepeatMode(Animation.REVERSE);
        out.setDuration(3000);
        text.startAnimation(out);


        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient googleSignInClient= GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount googleSignInAccount=GoogleSignIn.getLastSignedInAccount(this);

        if(googleSignInAccount !=null){
            Intent i = new Intent(FeaturesActivity.this, DashActivity.class);
            startActivity(i);
        }

        ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                //getting signed in account after user selected an account
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                handleSignInTask(task);


            }


            private void handleSignInTask(Task<GoogleSignInAccount> task) {
                try {
                    GoogleSignInAccount account = task.getResult(ApiException.class);

                    final String getFullName=account.getDisplayName();
                    final String getEmail=account.getEmail();
                    final Uri getPhotoUrl=account.getPhotoUrl();

                    Intent i = new Intent(FeaturesActivity.this, DashActivity.class);
                    startActivity(i);
                    finish();
                } catch (ApiException e) {
                    e.printStackTrace();
                   Toast.makeText(getApplicationContext(),"Failed To Fetch Account!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        google_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent =googleSignInClient.getSignInIntent();
                activityResultLauncher.launch(signInIntent);
            }
        });





        getStarted_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FeaturesActivity.this, DashActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}