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
        db.execSQL("INSERT INTO calories VALUES(NULL,'kimchi','25');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'dufu','88');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'apple','130');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'egg','80');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'sweetpotato','128');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'banana','93');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'strawberry','36');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'almond','7');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'beer','74');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'coke','108');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'pork and kimchi stew','128');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'sea mustard soup','83');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'sweet and sour pork','228');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'kimbap','318');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'cucumber','19');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'bread','111');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'noodles with black soybean sauce','785');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'hamburger','270');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'pizza','404');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'chiken','249');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'tteokbokki','280');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'jokbal','394');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'grilled fish','379');");



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS calories");
        onCreate(db);
    }






}
