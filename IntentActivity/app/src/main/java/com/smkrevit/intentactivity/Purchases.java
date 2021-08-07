package com.smkrevit.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Purchases extends AppCompatActivity {
    TextView tvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchases);
        load();
        takeData();
    }

    public void load() {
        tvItems = findViewById(R.id.purchases_tvItems);
    }

    public void takeData() {
        String data = getIntent().getStringExtra("purchasesContent");
        tvItems.setText(data);
    }
}