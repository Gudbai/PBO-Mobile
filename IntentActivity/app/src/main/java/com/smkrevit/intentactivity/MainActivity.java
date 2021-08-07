package com.smkrevit.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load() {
        etItems = findViewById(R.id.etItems);
    }

    public void btnItems(View view) {
        if (etItems.getText().toString().equals(""))
        {
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        } else {
            String items = etItems.getText().toString();
            Intent intent = new Intent(this, Items.class);
            intent.putExtra("itemContent", items);
            startActivity(intent);
        }
    }

    public void btnSales(View view) {
        if (etItems.getText().toString().equals(""))
        {
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        } else {
            String items = etItems.getText().toString();
            Intent intent = new Intent(this, Sales.class);
            intent.putExtra("salesContent", items);
            startActivity(intent);
        }
    }

    public void btnPurchases(View view) {
        if (etItems.getText().toString().equals(""))
        {
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        } else {
            String items = etItems.getText().toString();
            Intent intent = new Intent(this, Purchases.class);
            intent.putExtra("purchasesContent", items);
            startActivity(intent);
        }
    }
}