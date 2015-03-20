package android.csulb.edu.intentpractice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class StaticActivity extends Activity {

    private Button okButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);

        okButton = (Button) findViewById(R.id.staticButton);
        editText = (EditText) findViewById(R.id.staticEditText);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                StaticStorage.staticMessage = message;
                finish();
            }
        });
    }
}
