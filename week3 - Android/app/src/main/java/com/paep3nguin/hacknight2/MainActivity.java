package com.paep3nguin.hacknight2;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor accel;
    ImageView cuteDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cuteDog = (ImageView) findViewById(R.id.cute_dog);

        final TextView helloText = (TextView) findViewById(R.id.hello_text);
        helloText.setText("Hellooooo Hack Night!");

        Button button = (Button) findViewById(R.id.benjaminButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloText.setTextColor(Color.RED);
            }
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];
                helloText.setText(String.format("x: %f, y: %f, z: %f", x, y, z));
                double angle = (Math.atan2(y, x) - Math.PI / 2) * -180 / Math.PI;
                cuteDog.setRotation((float) angle);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        }, accel, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
