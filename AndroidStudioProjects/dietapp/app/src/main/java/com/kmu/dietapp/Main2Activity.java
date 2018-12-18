package com.kmu.dietapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import java.util.TooManyListenersException;

class myGlobals{

    public static double eat_cal;
    public static int cnt3;

    static double get_cal(){
        return eat_cal;
    }
    static void set_cal(double eat_cal){ myGlobals.eat_cal = eat_cal; }

    static int get_cnt(){return cnt3;}
    static void set_cnt(int cnt3){myGlobals.cnt3 = cnt3;}


}
public class Main2Activity extends AppCompatActivity {
    public static final String KEY_MY_PREFERENCE = "my_preference";
    Toolbar myToolbar;
    EditText weight ,goal;
    TextView goal_weight,height;
    int num_weight,num_goal,sub,num_hei,cnt,cnt2,cnt3;
    double rec_cal,add_kcal;
    String resultKcal,exercise,dates;

    private DBHelper3 mydb;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mydb  = new DBHelper3(this);

        try {
            db = mydb.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = mydb.getReadableDatabase();
        }

        Intent intent = getIntent();
        dates = intent.getStringExtra("Date");


        db.execSQL("INSERT INTO dates VALUES (null, '" + dates + "','"+"0"+"','"+"0"+"','"+" "+"');");

        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM dates WHERE date='" + dates + "';", null);
        cursor.moveToFirst();

        //날짜가 새로운게 클릭되면

        if(cursor.getCount()==1){
            myGlobals.set_cnt(0);
            myGlobals.set_cal(0);

        }

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        getSupportActionBar().setTitle("다이어리");  //해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리


        weight = (EditText) findViewById(R.id.edit_weight);
        goal = (EditText) findViewById(R.id.edit_goal);
        goal_weight = (TextView)findViewById(R.id.goal_weight);
        height = (TextView)findViewById(R.id.edit_hei);

        //간단한 변수들 공유하기 위해 sharedpreferences사용
        // 첫번째 인자는 키, 두번째 인자는 키에 대한 데이터가 존재하지 않을 경우의 디폴트값

        SharedPreferences prefs_weight = getSharedPreferences("pref_weight", MODE_PRIVATE);
        String text1 = prefs_weight.getString(KEY_MY_PREFERENCE, "");
        final EditText edit1 = (EditText) findViewById(R.id.edit_weight);
        edit1.setText(text1);

        SharedPreferences prefs_height = getSharedPreferences("pref_height", MODE_PRIVATE);
        String text2 = prefs_height.getString(KEY_MY_PREFERENCE, "");
        final EditText edit2 = (EditText) findViewById(R.id.edit_hei);
        edit2.setText(text2);

        SharedPreferences prefs_goal = getSharedPreferences("pref_goal", MODE_PRIVATE);
        String text3 = prefs_goal.getString(KEY_MY_PREFERENCE, "");
        final EditText edit3 = (EditText) findViewById(R.id.edit_goal);
        edit3.setText(text3);


        //액티비티 전환 코드
        //칼로리를 입력하는 횟수 -> cnt
        TextView bre_btn = (TextView) findViewById(R.id.bre_btn);
        bre_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;
                Intent intent = new Intent(Main2Activity.this, Meal.class);
                startActivityForResult(intent, 3000);

            }
        });
        TextView lun_btn = (TextView) findViewById(R.id.lun_btn);
        lun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;

                Intent intent = new Intent(Main2Activity.this, Meal.class);
                startActivityForResult(intent, 3000);
            }
        });
        TextView din_btn = (TextView) findViewById(R.id.din_btn);
        din_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;
                Intent intent = new Intent(Main2Activity.this, Meal.class);
                startActivityForResult(intent, 3000);
            }
        });

        //만보기를 호출하는 횟수 -> cnt2

        TextView pedo_btn  = (TextView) findViewById(R.id.pedo_btn);
        pedo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt2++;
                Intent intent = new Intent(Main2Activity.this,Pedometer.class);
                startActivityForResult(intent, 3001);
            }
        });

        //저장버튼을 누르는 횟수 ->cnt3

        TextView save_btn  = (TextView) findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt3 = myGlobals.get_cnt();
                cnt3++;
                myGlobals.set_cnt(cnt3);
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    protected void onStop() {

        super.onStop();

        // 데이타를저장합니다.
        EditText editText1 = (EditText) findViewById(R.id.edit_weight);
        String text1 = editText1.getText().toString();
        SharedPreferences prefs_weight = getSharedPreferences("pref_weight", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = prefs_weight.edit();
        editor1.putString(KEY_MY_PREFERENCE, text1);


        EditText editText2 = (EditText) findViewById(R.id.edit_hei);
        String text2 = editText2.getText().toString();
        SharedPreferences prefs_height = getSharedPreferences("pref_height", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = prefs_height.edit();
        editor2.putString(KEY_MY_PREFERENCE, text2);


        EditText editText3 = (EditText) findViewById(R.id.edit_goal);
        String text3 = editText3.getText().toString();
        SharedPreferences prefs_goal = getSharedPreferences("pref_goal", MODE_PRIVATE);
        SharedPreferences.Editor editor3 = prefs_goal.edit();
        editor3.putString(KEY_MY_PREFERENCE, text3);


        editor1.commit();
        editor2.commit();
        editor3.commit();

    }


    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    public void onResume() {
        super.onResume();
        double eat_kcal;
        String str_hei = height.getText().toString();
        ProgressBar proBar = (ProgressBar)findViewById(R.id.food_pro);

        //db에서 dates가 추가되었는지 query문 날리기
        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM dates WHERE date='" + dates + "';", null);
        cursor.moveToFirst();

        if(cursor.getCount()>0){

            //ProgressBar proBar = (ProgressBar)findViewById(R.id.food_pro);
            cnt3 = myGlobals.get_cnt();

            if(str_hei.length() > 0 && cnt == 1 && cnt3 == 0){

                num_hei = Integer.parseInt(str_hei);

                //권장 칼로리 계산
                rec_cal=((double)(num_hei/100.0)*(double)(num_hei/100.0)*20.0)*25.0;

                eat_kcal = Double.parseDouble(cursor.getString(cursor.getColumnIndex(DBHelper3.CAL_COLUMN_KCAL)));
                myGlobals.set_cal(eat_kcal);
                eat_kcal = eat_kcal/rec_cal;
                proBar.setProgress((int)(eat_kcal*100));

                //Meal.class에서 가져온 음식 칼로리 가져와서 추가해주기
                add_kcal = Double.parseDouble(resultKcal);
                eat_kcal  = eat_kcal + add_kcal;

                //값을 변경했으니 다시 저장하기
                myGlobals.set_cal(eat_kcal);

                String sql = "UPDATE dates SET kcal="+eat_kcal+" WHERE date="+dates+"";
                db.execSQL(sql);


                //prograssbar로 업데이트 해주기
                //(계산:)오늘 먹어야하는칼로리 / 오늘 먹은칼로리

                eat_kcal = eat_kcal/rec_cal;
                proBar.setProgress((int)(eat_kcal*100));

            }


            if(cnt > 1 && cnt3 == 0){
                rec_cal=((double)(num_hei/100.0)*(double)(num_hei/100.0)*20.0)*25.0;

                eat_kcal = myGlobals.get_cal();
                add_kcal = Double.parseDouble(resultKcal);
                eat_kcal  = eat_kcal + add_kcal;

                myGlobals.set_cal(eat_kcal);

                String sql = "UPDATE dates SET kcal="+eat_kcal+" WHERE date="+dates+"";
                db.execSQL(sql);

                eat_kcal = eat_kcal/rec_cal;

                proBar.setProgress((int)(eat_kcal*100));
            }

            if(cnt==0 && cnt3 != 0){

                eat_kcal = Double.parseDouble(cursor.getString(cursor.getColumnIndex(DBHelper3.CAL_COLUMN_KCAL)));
                num_hei = Integer.parseInt(str_hei);

                rec_cal=((double)(num_hei/100.0)*(double)(num_hei/100.0)*20.0)*25.0;
                eat_kcal = eat_kcal/rec_cal;
                proBar.setProgress((int)(eat_kcal*100));

                exercise = cursor.getString(cursor.getColumnIndex(DBHelper3.CAL_COLUMN_EXERCISE));
                ProgressBar proBar2 = (ProgressBar)findViewById(R.id.exer_pro);
                proBar2.setProgress(Integer.parseInt(exercise));

            }

            if(cnt2 > 0 && cnt3 == 0) {
                if(exercise==null){exercise = "0";}

                ProgressBar proBar2 = (ProgressBar)findViewById(R.id.exer_pro);
                proBar2.setProgress(Integer.parseInt(exercise));

            }


        }

          if(cnt > 1 && cnt3 == 0){
             rec_cal=((double)(num_hei/100.0)*(double)(num_hei/100.0)*20.0)*25.0;
             eat_kcal = myGlobals.get_cal();
            add_kcal = Double.parseDouble(resultKcal);
            eat_kcal  = eat_kcal + add_kcal;

            myGlobals.set_cal(eat_kcal);

            String sql = "UPDATE dates SET kcal="+eat_kcal+" WHERE date="+dates+"";
            db.execSQL(sql);

            eat_kcal = eat_kcal/rec_cal;

            proBar.setProgress((int)(eat_kcal*100));
         }

         if(cnt==0 && cnt3 != 0){

             eat_kcal = Double.parseDouble(cursor.getString(cursor.getColumnIndex(DBHelper3.CAL_COLUMN_KCAL)));
            num_hei = Integer.parseInt(str_hei);

            rec_cal=((double)(num_hei/100.0)*(double)(num_hei/100.0)*20.0)*25.0;
            eat_kcal = eat_kcal/rec_cal;
            proBar.setProgress((int)(eat_kcal*100));

            exercise = cursor.getString(cursor.getColumnIndex(DBHelper3.CAL_COLUMN_EXERCISE));
            ProgressBar proBar2 = (ProgressBar)findViewById(R.id.exer_pro);
            proBar2.setProgress(Integer.parseInt(exercise));

        }

        if(cnt2 > 0 && cnt3 == 0) {
            if(exercise==null){exercise = "0";}

            ProgressBar proBar2 = (ProgressBar)findViewById(R.id.exer_pro);
            proBar2.setProgress(Integer.parseInt(exercise));

        }

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode == RESULT_OK) {
            switch (requestCode){
                case 3000:
                    resultKcal=(data.getStringExtra("result"));
                    break;

                case 3001:
                    exercise = (data.getStringExtra("result"));

                    String sql = "UPDATE dates SET exercise="+exercise+" WHERE date="+dates+"";
                    db.execSQL(sql);
                    break;

            }
        }

    }

    //앞으로 몇키로 감량해야하는지 알려주는 메소드
    public void forward(View target){
        String str_weight = weight.getText().toString();
        String str_goal = goal.getText().toString();


        if(str_weight!="" && str_goal!="") {
            num_weight = Integer.parseInt(weight.getText().toString());
            num_goal = Integer.parseInt(goal.getText().toString());

            sub = num_weight - num_goal;

            goal_weight.setText(""+sub+"kg");

        }
    }



    //ToolBar에 menu.xml을 인플레이트함
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    //ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "환경설정 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return true;

            default:
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }
    }

    public void changeActivity(View view){
        Intent intent = new Intent(Main2Activity.this, Note.class);
        startActivityForResult(intent,3003);


    }


}
