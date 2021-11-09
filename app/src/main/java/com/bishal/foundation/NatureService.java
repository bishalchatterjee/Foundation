package com.bishal.foundation;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NatureService extends Service{
    MediaPlayer player;
    List<Integer> soundList = new ArrayList<Integer>();

    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        soundList.add(R.raw.birds);
        soundList.add(R.raw.bottleofwater);
        soundList.add(R.raw.campfire);
        soundList.add(R.raw.cricket);
        soundList.add(R.raw.forestmorning);
        soundList.add(R.raw.heavyrain);
        soundList.add(R.raw.highspeedwind);
        soundList.add(R.raw.moderaterain);
        soundList.add(R.raw.oceanwaves);
        soundList.add(R.raw.owl);
        soundList.add(R.raw.pegions);
        soundList.add(R.raw.rain);
        soundList.add(R.raw.raindropsonwindow);
        soundList.add(R.raw.river);
        soundList.add(R.raw.segull);
        soundList.add(R.raw.thunderstorm);

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


