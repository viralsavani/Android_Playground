package android.csulb.edu.intentpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AdditionalActivity extends Activity {

    public static String RETURN_MSG = "return_msg";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);

        Button okButton = (Button) findViewById(R.id.additionalOkButton);
        editText = (EditText) findViewById(R.id.additionalEditText);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();

                Intent intent = new Intent();
                intent.putExtra(RETURN_MSG, message);

                /**
                 * When the called activity is ready to finish, it could return an optional resultCode
                 * to the caller to summarize the success of its execution. The brief resultCode as
                 * well as any additional extra data can be collected back on the parent's using
                 */
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
