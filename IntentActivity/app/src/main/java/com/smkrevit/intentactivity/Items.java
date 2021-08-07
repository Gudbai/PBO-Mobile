package com.smkrevit.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Items extends AppCompatActivity {
    TextView tvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        load();
        takeData();
    }

    public void load() {
        tvItems = findViewById(R.id.items_tvItems);
    }

    public void takeData() {
        String data = getIntent().getStringExtra("itemContent");
        tvItems.setText(data);
    }
}