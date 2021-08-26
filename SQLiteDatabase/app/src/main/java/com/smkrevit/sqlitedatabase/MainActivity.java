package com.smkrevit.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Database db;
    EditText etItem, etStock, etPrice;
    TextView tvChoice;

    List<Item> itemData = new ArrayList<Item>();
    ItemAdapter adapter;
    RecyclerView rcvItem;

    String itemID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        selectData();
    }

    public void load() {
        db = new Database(this);
        db.makeTable();

        etItem = findViewById(R.id.etItemName);
        etStock = findViewById(R.id.etItemStock);
        etPrice = findViewById(R.id.etItemPrice);
        tvChoice = findViewById(R.id.tvChoice);
        rcvItem = findViewById(R.id.rcvItem);

        rcvItem.setLayoutManager(new LinearLayoutManager(this));
        rcvItem.setHasFixedSize(true);
    }

    public void save(View v) {
        String item = etItem.getText().toString();
        String stock = etStock.getText().toString();
        String price = etPrice.getText().toString();
        String choice = tvChoice.getText().toString();

        if (item.isEmpty() || stock.isEmpty() || price.isEmpty()) {
            showMessage("Data empty");
        } else {
            if (choice.equals("Insert")) {
                String sql = "INSERT INTO tblitems (item_name, stock, price) VALUES ('"+item+"', '"+stock+"', '"+price+"')";
                if (db.runSQL(sql)) {
                    showMessage("Data inserted");
                    selectData();
                } else {
                    showMessage("Failed to insert data");
                }
            } else {
                String sql = "UPDATE tblitems\n" +
                        "SET name = '"+item+"', stock = '"+stock+"', price = '"+price+"'\n" +
                        "WHERE id = "+itemID+" ;";

                if (db.runSQL(sql)) {
                    showMessage("Data update successful");
                    selectData();
                } else {
                    showMessage("Data update failed");
                }
            }
        }

        etItem.setText("");
        etStock.setText("");
        etPrice.setText("");
        tvChoice.setText("Insert");
    }

    public void showMessage(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    public void selectData() {
        String sql = "SELECT * FROM tblitems ORDER BY item_name ASC";
        Cursor cursor = db.select(sql);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String item_id  = cursor.getString(cursor.getColumnIndex("id"));
                String item_name  = cursor.getString(cursor.getColumnIndex("name"));
                String item_stock  = cursor.getString(cursor.getColumnIndex("stock"));
                String item_price  = cursor.getString(cursor.getColumnIndex("price"));

                itemData.add(new Item(item_id, item_name, item_stock, item_price));
            }

            adapter = new ItemAdapter(this, itemData);
            rcvItem.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else {
            showMessage("Data empty");
        }
    }

    public void deleteData(String id) {
        String item_id = id;

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("WARNING");
        alert.setMessage("Are you sure you want to delete the data?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String sql = "DELETE FROM tblitems WHERE id = "+item_id+";";
                if (db.runSQL(sql)) {
                    showMessage("Data deletion succeed");
                    selectData();
                } else {
                    showMessage("Data deletion failed");
                }
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }

    public void selectUpdate(String id) {
        itemID = id;
        String sql = "SELECT * FROM tblitems WHERE id = "+id+" ;";
        Cursor cursor = db.select(sql);
        cursor.moveToNext();

        etItem.setText(cursor.getString(cursor.getColumnIndex("name")));
        etStock.setText(cursor.getString(cursor.getColumnIndex("stock")));
        etPrice.setText(cursor.getString(cursor.getColumnIndex("price")));

        tvChoice.setText("Update");
    }
}