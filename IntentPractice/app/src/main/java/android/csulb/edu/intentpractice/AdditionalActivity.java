package android.csulb.edu.intentpractice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AdditionalActivity extends Activity {

    public static String RETURN_MSG = "return_msg";

    private Button okButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);

        okButton = (Button) findViewById(R.id.additionalOkButton);
        editText = (EditText) findViewById(R.id.additionalEditText);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();

                Intent intent = new Intent();
                intent.putExtra(RETURN_MSG , message);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
