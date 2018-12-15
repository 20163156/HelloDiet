package com.kmu.dietapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Meal extends AppCompatActivity {

    private DBHelper2 mydb;
    SQLiteDatabase db;
    EditText edit_foodName,edit_infokcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        mydb  = new DBHelper2(this);

        try {
            db = mydb.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = mydb.getReadableDatabase();
        }

        edit_foodName = (EditText) findViewById(R.id.edit_foodName);
        edit_infokcal = (EditText) findViewById(R.id.info_kcal);

    }

    public void search(View target) {
        String ed_foodName = edit_foodName.getText().toString();

        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM calories WHERE foodName='"
                + ed_foodName + "';", null);

        if(cursor.getCount() > 0){
            Toast.makeText(getApplicationContext(), "메뉴가 존재합니다..",
                    Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getApplicationContext(), "메뉴가 존재하지 않습니다.",
                    Toast.LENGTH_SHORT).show();
        }


    }



}







