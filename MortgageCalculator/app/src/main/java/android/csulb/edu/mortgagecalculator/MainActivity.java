package android.csulb.edu.mortgagecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener{

    EditText inputValue;
    TextView monthlyPaymentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputValue = (EditText) findViewById(R.id.amountBorrowed);
    }

    /**
     * OnClick of "Calculate Mortgage" button will call to calculateMortgage method
     * which takes View as argument
     */

    public void calculateMortgage(View view){
        switch(view.getId()){
            case R.id.calculateButton:

                /**
                 * Get the entire radioGroup and select only one radioButton which is selected.
                 * No need to make multiple radio buttons and then check which one is selected.
                 */

                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupLoanTerm);
                RadioButton radioLoanTerm = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String radioValue = radioLoanTerm.getText().toString();
                String[] radioValueSplit = radioValue.split("\\s");

                /**
                 * Check if input is not null, then only proceed
                 * If null simple output a TOAST and return.
                 */

                if(inputValue.getText().toString().trim().length() == 0){
                    Toast.makeText(this, "Please Enter Valid Amount !", Toast.LENGTH_LONG).show();
                    return;
                }else{
                    CheckBox taxInsuranceCheck = (CheckBox) findViewById(R.id.taxInsuranceCheckBox);

                    SeekBar interestRateBar = (SeekBar) findViewById(R.id.seekBar);
                    int interestRate = interestRateBar.getProgress();

                    Double principalAmount = Double.parseDouble(inputValue.getText().toString());
                    float monthlyInterest = (float) interestRate / 1200;
                    int numberOfMonths = Integer.parseInt(radioValueSplit[0]);
                    float monthlyPayment;
                    float taxInsurance;

                    if(taxInsuranceCheck.isChecked()){
                        taxInsurance = (float) (principalAmount * 0.1) / 100;
                    }else{
                        taxInsurance = 0;
                    }

                    if(interestRate == 0){
                        monthlyPayment = (float) ((principalAmount / numberOfMonths) + taxInsurance);
                    }else{
                        double temp = 1 / Math.pow(monthlyInterest+1,numberOfMonths);
                        temp = 1 - temp;
                        temp = monthlyInterest / temp;
                        temp = principalAmount * temp;
                        monthlyPayment = (float) (temp + taxInsurance);
                    }
                    monthlyPaymentTextView = (TextView) findViewById(R.id.monthlyPayment);
                    monthlyPaymentTextView.setText(String.valueOf(monthlyPayment));
                }
                break;
        }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
