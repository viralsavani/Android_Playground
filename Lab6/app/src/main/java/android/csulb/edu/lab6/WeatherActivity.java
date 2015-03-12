package android.csulb.edu.lab6;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class WeatherActivity extends ActionBarActivity {

    private SensorManager sensorManager;

    private TextView temperatureTextView;
    private TextView pressureTextView;
    private TextView lightTextView;

    private float temperature = Float.NaN;
    private float pressure = Float.NaN;
    private float light = Float.NaN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        pressureTextView = (TextView) findViewById(R.id.pressureTextView);
        lightTextView = (TextView) findViewById(R.id.lightTextView);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Timer refreshTimer = new Timer("refresh");
        refreshTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateGUI();
            }
        },0,1000);
    }

    private final SensorEventListener temperatureListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            temperature = event.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    private final SensorEventListener pressureListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            pressure = event.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    private final SensorEventListener lightListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            light = event.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };


    @Override
    protected void onResume() {
        super.onResume();

        Sensor temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(temperatureSensor != null){
            sensorManager.registerListener(temperatureListener, temperatureSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            temperatureTextView.setText("Temperature Sensor Unavailable");
        }

        Sensor pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if(pressureSensor != null){
            sensorManager.registerListener(pressureListener, pressureSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            temperatureTextView.setText("Pressure Sensor Unavailable");
        }

        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(lightSensor != null){
            sensorManager.registerListener(lightListener, lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            temperatureTextView.setText("Light Sensor Unavailable");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(temperatureListener);
        sensorManager.unregisterListener(pressureListener);
        sensorManager.unregisterListener(lightListener);
    }

    private void updateGUI(){
        runOnUiThread( new Runnable() {
            @Override
            public void run() {
                if( !Float.isNaN(temperature)){
                    temperatureTextView.setText(temperature + " C");
                    temperatureTextView.invalidate();
                }

                if( !Float.isNaN(light) ){
                    String climateType = "Sunny";

                    if(light <= SensorManager.LIGHT_CLOUDY){
                        climateType = "Night";
                    }else if(light <= SensorManager.LIGHT_OVERCAST){
                        climateType = "Cloudy";
                    }else if(light <= SensorManager.LIGHT_SUNLIGHT){
                        climateType = "Overcast";
                    }
                    lightTextView.setText(climateType);
                    lightTextView.invalidate();
                }

                if( !Float.isNaN(pressure)){
                    pressureTextView.setText(pressure + " (mBars)");
                    pressureTextView.invalidate();
                }
            }
        });
    }
}
