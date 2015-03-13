package android.csulb.edu.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void weatherDemo(View view){
        Intent weatherIntent = new Intent(MainActivity.this, WeatherActivity.class);
        startActivity(weatherIntent);
    }

    public void shakeDemo(View view){
        Intent shakeIntent = new Intent(MainActivity.this, ShakeActivity.class);
        startActivity(shakeIntent);
    }
}
