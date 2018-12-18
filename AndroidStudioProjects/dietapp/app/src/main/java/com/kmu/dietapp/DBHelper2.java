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

        db.execSQL("INSERT INTO calories VALUES(NULL,'쌀밥','310');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'아메리카노','4');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'김치','25');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'두부','88');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'사과','130');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'계란','80');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'고구마','128');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'바나나','93');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'딸기','36');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'아몬드','7');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'맥주','74');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'콜라','108');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'돼지고기김치찌개','128');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'미역국','83');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'탕수육','228');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'김밥','318');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'오이','19');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'빵','111');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'짜장면','785');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'햄버거','270');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'피자','404');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'치킨','249');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'떡볶이','280');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'족발','394');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'생선구이','379');");



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS calories");
        onCreate(db);
    }






}
