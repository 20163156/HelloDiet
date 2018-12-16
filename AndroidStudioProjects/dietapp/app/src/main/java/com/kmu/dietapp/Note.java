package com.kmu.dietapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Note extends AppCompatActivity {
    public static final String KEY_MY_PREFERENCE = "my_preference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        SharedPreferences prefs_note = getSharedPreferences("pref_note", MODE_PRIVATE);
        String text = prefs_note.getString(KEY_MY_PREFERENCE, "");
        final EditText edit = (EditText) findViewById(R.id.note);
        edit.setText(text);

    }

    protected void onStop(){
        super.onStop();

        EditText editText = (EditText) findViewById(R.id.note);
        String text = editText.getText().toString();

        // 데이타를저장합니다.
        SharedPreferences prefs_note = getSharedPreferences("pref_note", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs_note.edit();
        editor.putString(KEY_MY_PREFERENCE, text);

        editor.commit();

    }
}
