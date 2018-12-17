package com.kmu.dietapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper3 extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "MyDates.db";
    public static final String CAL_COLUMN_KCAL = "kcal";

    private static final int DATABASE_VERSION = 2;

    public DBHelper3(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE dates ( _id INTEGER PRIMARY KEY" +
                " AUTOINCREMENT, date TEXT,kcal TEXT);");



    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS dates");
        onCreate(db);
    }



}
