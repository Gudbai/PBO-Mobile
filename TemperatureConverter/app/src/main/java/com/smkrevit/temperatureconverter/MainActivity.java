package com.smkrevit.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spn;
    EditText initialVal;
    TextView resText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load() {
        spn = findViewById(R.id.spnOption);
        initialVal = findViewById(R.id.etInitialValue);
        resText = findViewById(R.id.tvResult);
    }

    /*
    public void fillSpinner() {
        String[] option = {"Celcius to Fahrenheit", "Celcius to Reamur", "Celcius to Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, option);
        spn.setAdapter(adapter);
    }
    */

    public void convertValue(View view) {
        String option = spn.getSelectedItem().toString();
        double value;
        double result;

        if (initialVal.getText().toString().equals("")) {
            Toast.makeText(this, "Value is empty", Toast.LENGTH_SHORT).show();
        } else {
            value = Double.parseDouble(initialVal.getText().toString());
            switch (option) {
                /* Celcius Initial Value */
                case "Celcius to Reamur":
                    result = (4.0/5.0) * value;
                    resText.setText(String.valueOf(result));
                    break;
                case "Celcius to Fahrenheit":
                    result = (9.0/5.0) * value + 32.0;
                    resText.setText(String.valueOf(result));
                    break;
                case "Celcius to Kelvin":
                    result = value + 273.0;
                    resText.setText(String.valueOf(result));
                    break;

                /* Reamur Initial Value */
                case "Reamur to Celcius":
                    result = (5.0/4.0) * value;
                    resText.setText(String.valueOf(result));
                    break;
                case "Reamur to Fahrenheit":
                    result = (9.0/4.0) * value + 32.0;
                    resText.setText(String.valueOf(result));
                    break;
                case "Reamur to Kelvin":
                    result = (5.0/4.0) * value + 273.0;
                    resText.setText(String.valueOf(result));
                    break;

                /* Fahrenheit Initial Value */
                case "Fahrenheit to Celcius":
                    result = (5.0/9.0) * (value - 32.0);
                    resText.setText(String.valueOf(result));
                    break;
                case "Fahrenheit to Reamur":
                    result = (4.0/9.0) * (value - 32.0);
                    resText.setText(String.valueOf(result));
                    break;
                case "Fahrenheit to Kelvin":
                    result = (5.0/9.0) * (value - 32.0) + 273.0;
                    resText.setText(String.valueOf(result));
                    break;

                /* Kelvin Initial Value */
                case "Kelvin to Celcius":
                    result = value - 273.0;
                    resText.setText(String.valueOf(result));
                    break;
                case "Kelvin to Reamur":
                    result = (4.0/5.0) * (value - 273.0);
                    resText.setText(String.valueOf(result));
                    break;
                case "Kelvin to Fahrenheit":
                    result = (9.0/5.0) * (value - 273.0) + 32.0;
                    resText.setText(String.valueOf(result));
                    break;
            }
        }
    }
}