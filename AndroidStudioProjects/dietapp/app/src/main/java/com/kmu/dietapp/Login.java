package com.kmu.dietapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Login extends AppCompatActivity {
    private DBHelper mydb;
    SQLiteDatabase db;
    EditText edit_id ,edit_pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView register_btn = (TextView) findViewById(R.id.registerBtn);
        register_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
  


    }





}



