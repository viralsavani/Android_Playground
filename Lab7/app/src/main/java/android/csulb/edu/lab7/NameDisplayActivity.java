package android.csulb.edu.lab7;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class NameDisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_display);

        Bundle myInput = this.getIntent().getExtras();
        TextView textView;
        textView = (TextView) findViewById(R.id.displayName);
        textView.setText(getString(R.string.hello)+", "+myInput.getString("userName"));
    }
}
