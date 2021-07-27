package com.smkrevit.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int num = 0;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load() {
        result = findViewById(R.id.tvNumber);
    }

    public void countUp(View view)
    {
        num++;
        result.setText(String.valueOf(num));
    }

    public void countDown(View view)
    {
        num--;
        result.setText(String.valueOf(num));
    }
}