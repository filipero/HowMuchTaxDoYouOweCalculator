package com.example.howmuchtaxdoyouowecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    EditText edtYearlyIncome;

    TextView txtTaxPercent, txtWeeklyTax, txtMonthlyTax,txtQuarterlyTax, txtYearlyTax, txtAfterTaxWeekly, txtAfterTaxMonthly, txtAfterTaxQuarterly, txtAfterTaxYearly;

    SeekBar sbTax;

    Button btnCalculate, btnClear;

    Double seekBarValue = 0d;
    Double taxPercent = 0d;

    Double taxWeekly = 0d;
    Double taxMonthly = 0d;
    Double taxQuarterly =0d;
    Double taxYearly = 0d;

    Double afterTaxWeekly = 0d;
    Double afterTaxMonthly = 0d;
    Double afterTaxQuarterly = 0d;
    Double afterTaxYearly = 0d;

    Double yearlyIncome = 0d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogic();
    }

    private void buttonLogic(){
        sbTax  = findViewById(R.id.seekBar);

        btnCalculate = findViewById(R.id.button2);
        btnClear = findViewById(R.id.button);



        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        sbTax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                edtYearlyIncome = findViewById(R.id.editTextYearlyIncome);

                yearlyIncome = Double.parseDouble(edtYearlyIncome.getText().toString());

                


                seekBarValue = (double)progress;
                taxPercent = seekBarValue / 100;
                calculate();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void calculate(){


        taxWeekly = yearlyIncome / 52 * taxPercent;
        taxMonthly = yearlyIncome / 12 * taxPercent;
        taxQuarterly =yearlyIncome / 4 * taxPercent;
        taxYearly = yearlyIncome * taxPercent;

        afterTaxWeekly = yearlyIncome / 52 - taxWeekly;
        afterTaxMonthly = yearlyIncome / 12 - taxMonthly;
        afterTaxQuarterly =yearlyIncome / 4 - taxQuarterly;
        afterTaxYearly = yearlyIncome - taxYearly;


        printVariables();
    }
    private void printVariables(){
        txtTaxPercent = findViewById(R.id.textViewTaxPercent);
        txtWeeklyTax = findViewById(R.id.textViewWeeklyTax);
        txtMonthlyTax = findViewById(R.id.textViewMonthlyTax);
        txtQuarterlyTax = findViewById(R.id.textViewQuarterlyTax);
        txtYearlyTax = findViewById(R.id.textViewYearlyTax);
        txtAfterTaxWeekly = findViewById(R.id.textViewAfterTaxWeekly);
        txtAfterTaxMonthly = findViewById(R.id.textViewAfterTaxMonthly);
        txtAfterTaxQuarterly = findViewById(R.id.textViewAfterTaxQuarterly);
        txtAfterTaxYearly = findViewById(R.id.textViewAfterTaxYearly);

        String formatTaxPercent = String.format("%1.0f",seekBarValue);

        txtTaxPercent.setText(formatTaxPercent + "%");

        String formattaxWeekly = String.format("%1.0f",taxWeekly);
        String formattaxMonthly = String.format("%1.0f",taxMonthly);
        String formattaxQuarterly = String.format("%1.0f",taxQuarterly);
        String formattaxYearly = String.format("%1.0f",taxYearly);

        String formatafterTaxWeekly = String.format("%1.0f",afterTaxWeekly);
        String formatafterTaxMonthly = String.format("%1.0f",afterTaxMonthly);
        String formatafterTaxQuarterly = String.format("%1.0f",afterTaxQuarterly);
        String formatafterTaxYearly = String.format("%1.0f",afterTaxYearly);

        txtWeeklyTax.setText("Weekly Tax: $" + formattaxWeekly);
        txtMonthlyTax.setText("Monthly Tax: $" + formattaxMonthly);
        txtQuarterlyTax.setText("Quarterly Tax: $"+formattaxQuarterly);
        txtYearlyTax.setText("Yearly Tax: $"+formattaxYearly);


        txtAfterTaxWeekly.setText("After Tax Weekly: $" + formatafterTaxWeekly);
        txtAfterTaxMonthly.setText("After Tax Monthly: $" + formatafterTaxMonthly);
        txtAfterTaxQuarterly.setText("After Tax Quarterly: $" + formatafterTaxQuarterly);
        txtAfterTaxYearly.setText("After Tax Yearly: $" + formatafterTaxYearly);

    }

    private void clear(){

        edtYearlyIncome = findViewById(R.id.editTextYearlyIncome);
        txtTaxPercent = findViewById(R.id.textViewTaxPercent);
        txtWeeklyTax = findViewById(R.id.textViewWeeklyTax);
        txtMonthlyTax = findViewById(R.id.textViewMonthlyTax);
        txtQuarterlyTax = findViewById(R.id.textViewQuarterlyTax);
        txtYearlyTax = findViewById(R.id.textViewYearlyTax);
        txtAfterTaxWeekly = findViewById(R.id.textViewAfterTaxWeekly);
        txtAfterTaxMonthly = findViewById(R.id.textViewAfterTaxMonthly);
        txtAfterTaxQuarterly = findViewById(R.id.textViewAfterTaxQuarterly);
        txtAfterTaxYearly = findViewById(R.id.textViewAfterTaxYearly);

        sbTax  = findViewById(R.id.seekBar);

        sbTax.setProgress(0);

        edtYearlyIncome.setText("");

        txtTaxPercent.setText("0%");

        txtWeeklyTax.setText("Weekly Tax: $$$$");
        txtMonthlyTax.setText("Monthly Tax: $$$$");
        txtQuarterlyTax.setText("Quarterly Tax: $$$$");
        txtYearlyTax.setText("Yearly Tax: $$$$");


        txtAfterTaxWeekly.setText("After Tax Weekly: $$$$");
        txtAfterTaxMonthly.setText("After Tax Monthly: $$$$");
        txtAfterTaxQuarterly.setText("After Tax Quarterly: $$$$");
        txtAfterTaxYearly.setText("After Tax Yearly: $$$$");

    }
}
