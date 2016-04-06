package com.example.ssardesai.homework1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText amount;
    private SeekBar interestRate;
    private TextView seekbarProgress;
    private RadioGroup noOfYears;
    private RadioButton years;
    private CheckBox tax;
    private Button calculate;
    TextView montlyPayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.amount);
        amount.setRawInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);

        amount.setKeyListener(DigitsKeyListener.getInstance(true, true));

        interestRate = (SeekBar) findViewById(R.id.interest);
        String defaultInterest = String.valueOf(interestRate.getProgress() / 10.00);

        seekbarProgress = (TextView) findViewById(R.id.interestRateProgress);
        seekbarProgress.setText(defaultInterest + "%");

        interestRate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double monthlyInterest = ((double) progress / 10.0);
                seekbarProgress.setText(String.valueOf(monthlyInterest) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        noOfYears = (RadioGroup) findViewById(R.id.radioGroup);
        tax = (CheckBox) findViewById(R.id.tax);
        montlyPayment = (TextView) findViewById(R.id.monthlypay);
        calculate = (Button) findViewById(R.id.calc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double payment = 0.0;
                double taxes = 0.0;
                double principal = 0.0;
                if (amount.getText().toString().equals("")) {
                    principal = 0.0;
                } else {
                    principal = Double.parseDouble(amount.getText().toString());
                }

                years = (RadioButton) findViewById(noOfYears.getCheckedRadioButtonId());
                String roi = seekbarProgress.getText().toString();
                String roiValue = roi.substring(0, roi.length() - 1);
                double annualInterest = Double.parseDouble(roiValue);
                double monthlyInterest = annualInterest / 1200;
                double year = Double.parseDouble(years.getText().toString());
                double months = year * 12;
                double denom = 1 - (Math.pow((1 + monthlyInterest), -months));
                taxes = 0.1 / 100 * principal;

                NumberFormat formattedValue = NumberFormat.getCurrencyInstance(Locale.US);

                if (principal == 0 || amount.getText().toString().contains("-")) {
                    Toast.makeText(MainActivity.this, R.string.popupMsg, Toast.LENGTH_SHORT).show();
                } else {
                    if (tax.isChecked()) {
                        if (!roiValue.equals("0.0")) {
                            payment = (principal * (monthlyInterest / denom)) + taxes;
                        } else {
                            payment = (principal / months) + taxes;
                        }
                    } else {
                        if (!roiValue.equals("0.0")) {
                            payment = (principal * (monthlyInterest / denom));
                        } else {
                            payment = (principal / months);
                        }
                    }

                }
                montlyPayment.setText(formattedValue.format(payment));
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
