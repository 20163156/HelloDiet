package com.kmu.dietapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;



public class Register extends AppCompatActivity {
    private DBHelper mydb;
    SQLiteDatabase db;
    EditText edit_id, edit_password,edit_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mydb  = new DBHelper(this);

        try {
            db = mydb.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = mydb.getReadableDatabase();
        }

        edit_id = (EditText) findViewById(R.id.idText);
        edit_password = (EditText) findViewById(R.id.idPassword);
        edit_email = (EditText) findViewById(R.id.idEmail);

    }

    public void insert(View target){

        String id = edit_id.getText().toString();
        String pd = edit_password.getText().toString();
        String em = edit_email.getText().toString();

        db.execSQL("INSERT INTO clients VALUES (null, '" + id + "', '" + pd
                + "','" + em + "');");
        Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.",
                Toast.LENGTH_SHORT).show();
        edit_id.setText("");
        edit_password.setText("");
        edit_email.setText("");
    }



}
