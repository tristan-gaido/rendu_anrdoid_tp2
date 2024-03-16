package com.example.tp2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private SensorManager sensorManager;
    private ListView sensorsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorsListView = findViewById(R.id.sensorsListView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        List<String> sensorNames = new ArrayList<>();
        for (Sensor sensor : deviceSensors) {
            sensorNames.add(sensor.getName() + " - Disponible");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, sensorNames);
        sensorsListView.setAdapter(adapter);
    }
}


