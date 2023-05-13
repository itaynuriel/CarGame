package com.example.hw1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class activity_main_sensorsMode extends AppCompatActivity implements SensorEventListener {

        private SensorManager sensorManager;
        private Sensor accelerometer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Get a reference to the SensorManager
            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

            // Get a reference to the accelerometer sensor
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        @Override
        protected void onResume() {
            super.onResume();

            // Register the accelerometer sensor listener
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        }

        @Override
        protected void onPause() {
            super.onPause();

            // Unregister the accelerometer sensor listener
            sensorManager.unregisterListener(this);
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];

//             Update car's position based on the accelerometer data
//             X value to tilt car left and right
//             Y value to control car's speed
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // emptyyy
        }

    }
