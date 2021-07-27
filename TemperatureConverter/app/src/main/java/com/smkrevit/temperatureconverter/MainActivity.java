package com.smkrevit.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        fillSpinner();
    }

    public void load() {
        spn = findViewById(R.id.spnOption);
    }

    public void fillSpinner() {
        String[] option = {"Celcius to Fahrenheit", "Celcius to Reamur", "Celcius to Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, option);
        spn.setAdapter(adapter);
    }

    public void convertValue(View view) {
        String option = spn.getSelectedItem().toString();

        System.out.println(option);
    }
}