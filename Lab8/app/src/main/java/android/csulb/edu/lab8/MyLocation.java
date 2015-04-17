package android.csulb.edu.lab8;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MyLocation extends ActionBarActivity {

    private Button locationButton;
    private GPSTracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);

        locationButton = (Button) findViewById(R.id.button_location);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tracker = new GPSTracker(MyLocation.this);
                if(tracker.canGetLocation()){
                    double latitude = tracker.getLatitude();
                    double longitude = tracker.getLongitude();
                    Toast.makeText(getApplicationContext(), "YOUR LOCATION IS - \n LATITUDE :: " + latitude +
                            "\nLONGITUDE :: " + longitude, Toast.LENGTH_LONG);
                }else {
                    tracker.showSettingAlert();
                }
            }
        });
    }
}
