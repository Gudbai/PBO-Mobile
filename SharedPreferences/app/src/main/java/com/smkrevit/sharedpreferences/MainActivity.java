package com.smkrevit.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView etItem, etStock;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load() {
        etItem = findViewById(R.id.etItemName);
        etStock = findViewById(R.id.etItemStock);
        sharedPreferences = getSharedPreferences("item", MODE_PRIVATE);
    }

    public void fillSharedPreferences(String item, float stock) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Item", item);
        editor.putFloat("Stock", stock);
        editor.apply();
    }

    public void save(View view) {
        String item = etItem.getText().toString();
        float stock = Float.parseFloat(etStock.getText().toString());

        if (item.isEmpty() || stock == 0.00) {
            Toast.makeText(this, "Data empty", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
        }

        etItem.setText("");
        etStock.setText("");
    }

    public void show(View view) {
        String item = sharedPreferences.getString("item", "");
        float stock = sharedPreferences.getFloat("stock", 0);

        etItem.setText(item);
        etStock.setText(stock+"");
    }
}