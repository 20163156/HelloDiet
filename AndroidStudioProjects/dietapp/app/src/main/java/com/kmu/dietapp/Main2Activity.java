package com.kmu.dietapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import java.util.TooManyListenersException;


public class Main2Activity extends AppCompatActivity {
    Toolbar myToolbar;
    EditText weight ,goal;
    TextView goal_weight;
    int num_weight,num_goal,sub;
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


        TextView bre_btn = (TextView) findViewById(R.id.bre_btn);
        bre_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(getApplicationContext(), Meal.class);
                startActivity(intent);
            }
        });
        TextView lun_btn = (TextView) findViewById(R.id.lun_btn);
        lun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(getApplicationContext(), Meal.class);
                startActivity(intent);
            }
        });
        TextView din_btn = (TextView) findViewById(R.id.din_btn);
        din_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(getApplicationContext(), Meal.class);
                startActivity(intent);
            }
        });


    }
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

    //추가된 소스, ToolBar에 menu.xml을 인플레이트함
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "환경설정 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }
    }
}
