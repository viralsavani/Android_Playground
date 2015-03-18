package android.csulb.edu.lab7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class NameGetterMain extends Activity implements View.OnClickListener {

    private EditText name;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_getter_main);

        name = (EditText) this.findViewById(R.id.nameGetter);
        button = (Button) this.findViewById(R.id.nameButton);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NameDisplayActivity.class);
        intent.putExtra("userName", name.getText().toString());
        this.startActivity(intent);
    }
}
