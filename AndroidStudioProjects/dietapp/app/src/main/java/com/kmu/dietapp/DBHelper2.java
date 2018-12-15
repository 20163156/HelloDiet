package com.kmu.dietapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper2 extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "MyCalories.db";
    public static final String TABLE_NAME = "calories";
    public static final String CAL_COLUMN_ID = "id";
    public static final String CAL_COLUMN_FOOD = "foodname";
    public static final String CAL_COLUMN_KCAL = "kcal";



    private static final int DATABASE_VERSION = 2;

    public DBHelper2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table calories " +
                        "(id integer primary key,foodname text, kcal text)"
        );


        db.execSQL("INSERT INTO calories VALUES(NULL,'rice','50');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'americano','1');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS calories");
        onCreate(db);
    }

//    public boolean insertFood(String foodname, String kcal) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put("name", foodname);
//        contentValues.put("director", kcal);
//
//        db.insert("c", null, contentValues);
//        return true;
//    }



}

