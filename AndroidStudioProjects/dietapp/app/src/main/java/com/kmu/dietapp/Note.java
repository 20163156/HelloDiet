package com.kmu.dietapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

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

//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        String mImageUri = preferences.getString("image", null);
//        mImage.setImageURI(Uri.parse(mImageUri));

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

//                    this.grantUriPermission(this.getPackageName(), mImageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                    final int takeFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
//                    this.getContentResolver().takePersistableUriPermission(mImageUri, takeFlags);
//
//                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//                    SharedPreferences.Editor editor2 = preferences.edit();
//                    editor2.putString("image", String.valueOf(mImageUri));
//                    editor2.commit();

                    mImage.setImageURI(mImageUri);
                    mImage.invalidate();
                }
            }
        }
    }





}
