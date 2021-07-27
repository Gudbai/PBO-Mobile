package com.smkrevit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load() {
        num1 = findViewById(R.id.etn_1);
        num2 = findViewById(R.id.etn_2);
        res = findViewById(R.id.tvResult);
    }

    public void CountRes (View view) {
        if (num1.getText().toString().equals("") || num2.getText().toString().equals(""))
        {
            Toast.makeText(this, "One of the number is empty", Toast.LENGTH_SHORT).show();
        } else {
            double number1 = Double.parseDouble(num1.getText().toString());
            double number2 = Double.parseDouble(num2.getText().toString());

            double result;

            Button btn = (Button)view;
            String chosenBtn = btn.getText().toString();

            switch(chosenBtn) {
                case "Add":
                    result = number1 + number2;
                    res.setText(String.valueOf(result));
                    break;
                case "Subtract":
                    result = number1 - number2;
                    res.setText(String.valueOf(result));
                    break;
                case "Multiply":
                    result = number1 * number2;
                    res.setText(String.valueOf(result));
                    break;
                case "Divide":
                    result = number1 / number2;
                    res.setText(String.valueOf(result));
                    break;
            }
        }
    }
}