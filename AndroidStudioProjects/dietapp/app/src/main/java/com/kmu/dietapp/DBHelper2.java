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
        db.execSQL("INSERT INTO calories VALUES(NULL,'제육볶음','572');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'짬뽕','764');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'계란찜','212');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'콩나물무침','38');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'청포도','47');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'소불고기','489');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'김치볶음밥','446');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'계란말이','112');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'돈까스','568');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'삼겹살','460');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'계란후라이','89');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'브로콜리','33');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'백숙','394');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'라면','500');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'삼겹살','460');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'설렁탕','424');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'갈비탕','466');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'소시지야채볶음','151');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'비빔밥','586');");
        db.execSQL("INSERT INTO calories VALUES(NULL,'우동','722');");






    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS calories");
        onCreate(db);
    }






}
