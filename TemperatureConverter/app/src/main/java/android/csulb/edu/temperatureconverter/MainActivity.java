package android.csulb.edu.temperatureconverter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.button:
                RadioButton celsiusRadio = (RadioButton) findViewById(R.id.celsiusRadio);
                RadioButton fahrenheitRadio = (RadioButton) findViewById(R.id.fahrenheitRadio);

                if(editText.getText().length() == 0){
                    Toast.makeText(this, "Enter a valid number", Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(editText.getText().toString());

                if(celsiusRadio.isChecked()){
                    editText.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    celsiusRadio.setChecked(false);
                    fahrenheitRadio.setChecked(true);
                }else{
                    editText.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    fahrenheitRadio.setChecked(false);
                    celsiusRadio.setChecked(true);
                }
                break;
        }
    }
}
