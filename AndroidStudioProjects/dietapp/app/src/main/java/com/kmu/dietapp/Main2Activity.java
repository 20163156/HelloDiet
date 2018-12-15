package com.kmu.dietapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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

    static double get_cal(){
        return eat_cal;
    }
    static void set_cal(double eat_cal){
        myGlobals.eat_cal = eat_cal;

    }


}
public class Main2Activity extends AppCompatActivity {
    Toolbar myToolbar;
    EditText weight ,goal;
    TextView goal_weight,height;
    int num_weight,num_goal,sub,num_hei;
    double rec_cal,add_kcal;
    String resultKcal;
    int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        getSupportActionBar().setTitle("다이어리");  //해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리

        weight = (EditText) findViewById(R.id.edit_weight);
        goal = (EditText) findViewById(R.id.edit_goal);
        goal_weight = (TextView)findViewById(R.id.goal_weight);
        height = (TextView)findViewById(R.id.edit_hei);

        TextView bre_btn = (TextView) findViewById(R.id.bre_btn);
        bre_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
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
                // 액티비티 전환 코드
                cnt++;

                Intent intent = new Intent(Main2Activity.this, Meal.class);
                startActivityForResult(intent, 3000);
            }
        });

        TextView save_btn  = (TextView) findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드

                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivityForResult(intent, 3000);
            }
        });


    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    public void onResume() {
        super.onResume();
        double eat_kcal;

        String str_hei = height.getText().toString();
        eat_kcal = myGlobals.get_cal();

        if(str_hei.length() > 0 && cnt == 1){

            num_hei = Integer.parseInt(str_hei);

            rec_cal=((double)(num_hei/100.0)*(double)(num_hei/100.0)*20.0)*25.0;
            add_kcal = Double.parseDouble(resultKcal);
            eat_kcal  = eat_kcal + add_kcal;
            myGlobals.set_cal(eat_kcal);

            eat_kcal = eat_kcal/rec_cal;

            ProgressBar proBar = (ProgressBar)findViewById(R.id.food_pro);
            proBar.setProgress((int)(eat_kcal*100));

        }

        if(cnt > 1){
            eat_kcal = myGlobals.get_cal();

            add_kcal = Double.parseDouble(resultKcal);
            eat_kcal  = eat_kcal + add_kcal;
            myGlobals.set_cal(eat_kcal);

            eat_kcal = eat_kcal/rec_cal;

            ProgressBar proBar = (ProgressBar)findViewById(R.id.food_pro);
            proBar.setProgress((int)(eat_kcal*100));
        }



    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode == RESULT_OK) {
            switch (requestCode){
                case 3000:
                    resultKcal=(data.getStringExtra("result"));
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
        startActivity(intent);
    }


}
