package com.kmu.dietapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Pedometer extends AppCompatActivity {
    private TextView gx, gy, gz;
    private TextView stepsTextView;
    private Button reset;

    private SensorManager sensorManager;
    private float acceleration;


    private float previousY, currentY;
    private int steps;

    int threshold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);

        gx = (TextView) findViewById(R.id.gx);
        gy = (TextView) findViewById(R.id.gy);
        gz = (TextView) findViewById(R.id.gz);

        stepsTextView = (TextView) findViewById(R.id.steps);


        threshold = 5;

        previousY = currentY = steps = 0;

        acceleration = 0.0f;

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(stepDetector, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

    }

    private SensorEventListener stepDetector = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            currentY = y;

            if (Math.abs(currentY - previousY) > threshold) {
                steps++;
                stepsTextView.setText(String.valueOf(steps));
            }
            gx.setText(String.valueOf(x));
            gy.setText(String.valueOf(y));
            gz.setText(String.valueOf(z));

            previousY = y;


        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public void resetSteps(View v) {
        steps = 0;
        stepsTextView.setText(String.valueOf(steps));
    }


}