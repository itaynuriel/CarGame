package com.example.hw1.Utilities;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import com.example.hw1.R;
import com.google.android.material.textview.MaterialTextView;


public class signalGenerator extends Application {
        private static signalGenerator instance;
        private static MediaPlayer mediaPlayer;
        private Context context;
        private static Vibrator vibrator;


        private signalGenerator(Context context) {
            this.context = context;
        }

        public static void init(Context context) {
            if (instance == null) {
                instance = new signalGenerator(context);
                mediaPlayer = MediaPlayer.create(context, R.raw.app_src_main_res_raw_game_over_sound);
                vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            }
        }

        public static signalGenerator getInstance()
        {
            return instance;
        }

        public void toast(String text,int length){
            Toast.makeText(context,text,length).show();
        }

        public void vibrate(long duration){
            vibrator.vibrate(duration);
        }
        public void playSound()
        {
            mediaPlayer.start();
        }

    }

