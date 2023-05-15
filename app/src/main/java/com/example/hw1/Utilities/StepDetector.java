package com.example.hw1.Utilities;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class StepDetector {

    private Sensor sensor;
    private SensorManager sensorManager;

    private StepCallback stepCallback;

    private int stepCounterX = 0;
    public int stepCounterY = 0;
    private long timestamp = 0;


    private SensorEventListener sensorEventListener;

    public StepDetector(Context context, StepCallback stepCallback) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        this.stepCallback = stepCallback;
        initEventListener();
    }

    private void initEventListener() {
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[0];
                float y = event.values[1];

//             Update car's position based on the accelerometer data
//             X value to tilt car left and right
//             Y value to control car's speed

                calculateStep(x, y);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // pass
            }
        };
    }

    private void calculateStep(float x, float y) {
        if (System.currentTimeMillis() - timestamp > 500) {
            timestamp = System.currentTimeMillis();
            if (x > 1.0) {
                stepCounterX = 0;
                stepCallback.stepX();
            } else {
                stepCounterX = 1;
                stepCallback.stepX();
            }
                Log.d("ptttt", "" + y);
            if (y >8) {
                stepCounterY+=50;
                stepCallback.stepY();
            }
            if (y <6)
            {
                stepCounterY-=50;
                stepCallback.stepY();
            }
        }
    }

    public int getStepsY() {
        return this.stepCounterY;
    }

    public int getStepsX() {
        return this.stepCounterX;
    }

    public void start() {
        sensorManager.registerListener(
                sensorEventListener,
                sensor,
                SensorManager.SENSOR_DELAY_NORMAL
        );
    }

    public void stop() {
        sensorManager.unregisterListener(
                sensorEventListener,
                sensor
        );
    }

}

