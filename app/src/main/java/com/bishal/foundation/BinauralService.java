package com.bishal.foundation;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinauralService extends Service {


    MediaPlayer player;
    List<Integer> soundList = new ArrayList<Integer>();

    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        soundList.add(R.raw.acupunture);
        soundList.add(R.raw.binaural0);
        soundList.add(R.raw.binaural1);
        soundList.add(R.raw.binaural2);
        soundList.add(R.raw.binaural3);
        soundList.add(R.raw.binaural4);
        soundList.add(R.raw.binaural5);
        soundList.add(R.raw.binaural6);
        soundList.add(R.raw.binaural7);
        soundList.add(R.raw.binaural8);
        soundList.add(R.raw.binaural9);
        soundList.add(R.raw.circulation);
        soundList.add(R.raw.depression);
        soundList.add(R.raw.intelligence);
        soundList.add(R.raw.jacqua);
        soundList.add(R.raw.regeneration);
        if (player == null) {
            int randomInt = (new Random().nextInt(soundList.size()));
            int sound = soundList.get(randomInt);
            player = MediaPlayer.create(this, sound);
            player.setLooping(true); // Set looping
            player.setVolume(100, 100);
//            Toast.makeText(this, "Service started...", Toast.LENGTH_SHORT).show();
        }
    }


        public int onStartCommand (Intent intent,int flags, int startId){
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

