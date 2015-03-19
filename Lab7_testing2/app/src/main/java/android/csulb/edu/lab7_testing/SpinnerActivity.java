package android.csulb.edu.lab7_testing;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;


public class SpinnerActivity extends Activity {


    private SharedPreferences sharedPreferences;

    private final String STORED_SPINNER_POSITION = "position_spinner";
    private final int DEFAULT_SPINNER_VALUE = -1;
    private final String[] SPINNER_VALUES = new String[] {"Select Weather...", "Sunny", "Partly Cloudy", "Cloudy", "Rain", "Snow", "Hurricane"};

    static final int WEATHER_NOSELECTION = 0;
    static final int WEATHER_SUNNY = 1;
    static final int WEATHER_PARTLY_CLOUDY = 2;
    static final int WEATHER_CLOUDY = 3;
    static final int WEATHER_RAIN = 4;
    static final int WEATHER_SNOW = 5;
    static final int WEATHER_HURRICANE = 6;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SpinnerActivity.this);

        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_layout, new ArrayList<>(Arrays.asList(SPINNER_VALUES))));

        int current = sharedPreferences.getInt(STORED_SPINNER_POSITION, DEFAULT_SPINNER_VALUE);
        if(current != DEFAULT_SPINNER_VALUE){
            spinner.setSelection(current);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sharedPreferences.edit().putInt(STORED_SPINNER_POSITION,position).commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                sharedPreferences.edit().remove(STORED_SPINNER_POSITION).commit();
            }
        });
    }

}
