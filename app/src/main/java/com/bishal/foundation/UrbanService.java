package com.bishal.foundation;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UrbanService extends Service {
    MediaPlayer player;
    List<Integer> soundList = new ArrayList<Integer>();

    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        soundList.add(R.raw.airport);
        soundList.add(R.raw.cafe);
        soundList.add(R.raw.chimney);
        soundList.add(R.raw.clock);
        soundList.add(R.raw.construction);
        soundList.add(R.raw.keyboardstroke);
        soundList.add(R.raw.shower);
        soundList.add(R.raw.sirenpolice);
        soundList.add(R.raw.traffic);
        soundList.add(R.raw.train);
        soundList.add(R.raw.vacumcleaner);
        soundList.add(R.raw.waterdroplets);

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