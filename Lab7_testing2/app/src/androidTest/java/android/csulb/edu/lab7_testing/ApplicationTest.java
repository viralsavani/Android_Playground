package android.csulb.edu.lab7_testing;

import android.app.Activity;
import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;
import android.widget.Spinner;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<SpinnerActivity> {
    public ApplicationTest() {
        super("android.csulb.edu.lab7_testing",SpinnerActivity.class);
    }

    public void testSpinnerValuePersistence(){
        final int TEST_SPINNER_POSITION_1 = SpinnerActivity.WEATHER_PARTLY_CLOUDY;

        Activity activity = getActivity();
        final Spinner spinner1 = (Spinner) activity.findViewById(R.id.spinner);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                spinner1.requestFocus();
                spinner1.setSelection(TEST_SPINNER_POSITION_1);
            }
        });

        activity.finish();
        setActivity(null);

        activity = this.getActivity();
        final Spinner spinner2 = (Spinner) activity.findViewById(R.id.spinner);
        int currentPosition = spinner2.getSelectedItemPosition();
        assertEquals(TEST_SPINNER_POSITION_1, currentPosition);

        final int TEST_SPINNER_POSITION_2 = SpinnerActivity.WEATHER_SNOW;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                spinner2.requestFocus();
                spinner2.setSelection(TEST_SPINNER_POSITION_2);
            }
        });

        activity.finish();
        setActivity(null);

        activity = this.getActivity();

        final Spinner spinner3 = (Spinner) activity.findViewById(R.id.spinner);
        currentPosition = spinner3.getSelectedItemPosition();
        assertEquals(TEST_SPINNER_POSITION_2, currentPosition);
    }
}