package com.example.audioplayer2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    MediaPlayer m;
    public void play(View view){
        m.start();
    }
    public void pause(View view){
        m.pause();
    }
    public void stop(View view){
        m.stop();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
            getWindow().setNavigationBarColor(getResources().getColor(R.color.purple_500));
        }
        m=MediaPlayer.create(this,R.raw.music);
        final AudioManager aud = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int max = aud.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int pro=aud.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar s=findViewById(R.id.sb);
        s.setMax(max);
        s.setProgress(pro);
        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                aud.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}