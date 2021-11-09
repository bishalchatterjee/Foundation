package com.bishal.foundation;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RelaxService extends Service {
    MediaPlayer player;
    List<Integer> soundList = new ArrayList<Integer>();

    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        soundList.add(R.raw.relax1);
        soundList.add(R.raw.relax2);
        if (player == null) {
            int randomInt = (new Random().nextInt(soundList.size()));
            int sound = soundList.get(randomInt);
            player = MediaPlayer.create(this, sound);
            player.setLooping(true); // Set looping
            player.setVolume(100, 100);
//            Toast.makeText(this, "Service started...", Toast.LENGTH_SHORT).show();
        }
    }


    public int onStartCommand (Intent intent, int flags, int startId){
        player.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy () {
        player.stop();
        player.release();
//            Toast.makeText(this, "Service stopped...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLowMemory () {
    }
}

