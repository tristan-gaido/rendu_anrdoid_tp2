package com.example.tp2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

public class MainActivity extends Activity {

    SensorManager sensorManager;
    List<Sensor> sensors;
    ListView sensorListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorListView = findViewById(R.id.sensorListView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        ArrayAdapter<Sensor> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sensors);
        sensorListView.setAdapter(adapter);
    }
}
