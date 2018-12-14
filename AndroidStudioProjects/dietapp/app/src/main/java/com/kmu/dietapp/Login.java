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
        mydb  = new DBHelper(this);

        try {
            db = mydb.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = mydb.getReadableDatabase();
        }

        edit_id = (EditText) findViewById(R.id.idText);
        edit_pd = (EditText) findViewById(R.id.idPassword);



    }

    public void login(View target) {
        String ed_id = edit_id.getText().toString();
        String ed_pd = edit_pd.getText().toString();

        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM clients WHERE id='"
                + ed_id + "'AND password='"+ed_pd+"';", null);

        if(cursor.getCount() > 0){
            Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(getApplicationContext(), "로그인에 실패했습니다.",
                    Toast.LENGTH_SHORT).show();
        }



    }



}



