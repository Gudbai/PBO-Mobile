package com.smkrevit.sqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbschool";
    private static final int VERSION = 1;
    SQLiteDatabase db;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        db = this.getWritableDatabase();
    }

    boolean runSQL(String sql) {
        try {
            db.execSQL(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void makeTable() {
        String tblcustomer = "CREATE TABLE \"tblcustomer\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"name\"\tTEXT NOT NULL,\n" +
                "\t\"address\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";

        runSQL(tblcustomer);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
