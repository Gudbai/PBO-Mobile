package com.smkrevit.messagedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("ATTENTION");
        alert.setMessage(message);

        alert.show();
    }

    public void showAlert2(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("ATTENTION");
        alert.setMessage(message);

        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Data erased");
            }
        });

        alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Data not erased");
            }
        });

        alert.show();
    }

    public void btnToast(View view) {
        showToast("yahooooooooooooooooooooo");
    }

    public void btnDialog1(View view) {
        showAlert("yahooooooooooooooooooooo");
    }

    public void btnDialog2(View view) {
        showAlert2("yahooooooooooooooooooooo");
    }

}