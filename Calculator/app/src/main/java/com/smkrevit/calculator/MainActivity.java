package com.smkrevit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CountRes (View view) {
        num1 = findViewById(R.id.etn_1);
        num2 = findViewById(R.id.etn_2);
        res = findViewById(R.id.tv_result);

        double number1 = Double.parseDouble(num1.getText().toString());
        double number2 = Double.parseDouble(num2.getText().toString());

        Calculator cal = new Calculator();

        double result = cal.multiply(number1, number2);

        res.setText(String.valueOf(result));
    }
}