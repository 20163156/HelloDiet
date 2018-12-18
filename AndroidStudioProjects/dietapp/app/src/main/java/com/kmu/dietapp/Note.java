package com.kmu.dietapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Note extends AppCompatActivity {

    public static final String KEY_MY_PREFERENCE = "my_preference";

    Button button;
    EditText edit_note;
    String note;

    ImageView mImage;
    Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mImage = (ImageView)findViewById(R.id.image);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageSelect();
            }

        });

        edit_note = (EditText)findViewById(R.id.note);
        note = edit_note.getText().toString();


        SharedPreferences prefs_note = getSharedPreferences("pref_note", MODE_PRIVATE);
        String text = prefs_note.getString(KEY_MY_PREFERENCE, "");
        final EditText edit = (EditText) findViewById(R.id.note);
        edit.setText(text);

    }

    public void imageSelect() {
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 3000);
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 3000) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                if (data != null) {

                    mImageUri = data.getData();

                    mImage.setImageURI(mImageUri);
                    mImage.invalidate();
                }
            }
        }
    }





}