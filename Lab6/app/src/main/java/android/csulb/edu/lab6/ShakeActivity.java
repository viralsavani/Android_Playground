package android.csulb.edu.lab6;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ShakeActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private boolean color = false;
    private View view;
    private long lastUpdateTime;

    private TextView xAxisTextView;
    private TextView yAxisTextView;
    private TextView zAxisTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);

        xAxisTextView = (TextView) findViewById(R.id.xAxis);
        yAxisTextView = (TextView) findViewById(R.id.yAxis);
        zAxisTextView = (TextView) findViewById(R.id.zAxis);

        view = findViewById(R.id.shakeView);
        view.setBackgroundColor(Color.BLUE);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        lastUpdateTime = System.currentTimeMillis();
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            displayAccelerometer(event);
            checkShake(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private void displayAccelerometer(SensorEvent event){
        float xAxis = event.values[0];
        float yAxis = event.values[1];
        float zAxis = event.values[2];

        xAxisTextView.setText("X-AXIS" + "\t\t"+ xAxis);
        yAxisTextView.setText("Y-AXIS" + "\t\t"+ yAxis);
        zAxisTextView.setText("Z-AXIS" + "\t\t"+ zAxis);
    }

    private void checkShake(SensorEvent event){
        float xAxis = event.values[0];
        float yAxis = event.values[1];
        float zAxis = event.values[2];

        float accelerationRoot = (xAxis*xAxis + yAxis*yAxis + zAxis*zAxis) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = System.currentTimeMillis();

        if(accelerationRoot >= 2){
            if(actualTime - lastUpdateTime < 200){
                return;
            }
            lastUpdateTime = actualTime;
            Toast.makeText(this, "Shake It Off!", Toast.LENGTH_SHORT).show();
            if(color){
                view.setBackgroundColor(Color.BLUE);
            }else{
                view.setBackgroundColor(Color.RED);
            }
            color = !color;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
