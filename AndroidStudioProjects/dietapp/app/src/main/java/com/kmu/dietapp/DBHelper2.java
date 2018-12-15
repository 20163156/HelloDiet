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

        db.execSQL("INSERT INTO calories VALUES(NULL,'rice','310');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'americano','4');");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS calories");
        onCreate(db);
    }






}
