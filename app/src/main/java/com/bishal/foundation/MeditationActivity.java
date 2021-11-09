package com.bishal.foundation;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MeditationActivity extends AppCompatActivity {

    Animation cardview_anim;
    ImageView cardview1;
    ImageButton play_btn,stop_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);

        VolumeControls();
        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);





        cardview1=findViewById(R.id.cardView1_img);
        cardview_anim= AnimationUtils.loadAnimation(this, R.anim.cardview_anim);

        cardview1.setAnimation(cardview_anim);


        play_btn = findViewById(R.id.play);
        stop_btn = findViewById(R.id.stop);

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startService(new Intent(MeditationActivity.this, MeditationService.class));

            }
            public void onBackPressed(){
                stopService(new Intent(MeditationActivity.this, MeditationService.class));

            }
        });
        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopService(new Intent(MeditationActivity.this, MeditationService.class));

            }
        });

    }
    private void VolumeControls() {

        SeekBar seekBar = (SeekBar)findViewById(R.id.volume_seekbar);

        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        seekBar.setMax(audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBar.setProgress(audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC));


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar arg0){
            }

            public void onStartTrackingTouch(SeekBar arg0){
            }

            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
            {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0);
                String Volume="Volume - "+String.valueOf(progress);
                Toast.makeText(MeditationActivity.this,Volume,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
