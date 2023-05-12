package com.aitr.acroconnect;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth auth;
    RelativeLayout rl_TimeTable, rl_Class, rl_Notice, rl_Store;
    ImageView img_Timetable;
    TextView tv_StudentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        rl_TimeTable = findViewById(R.id.rl_TimeTable);
        rl_Class = findViewById(R.id.rl_Class);
        rl_Notice = findViewById(R.id.rl_Notice);
        rl_Store = findViewById(R.id.rl_Store);
        img_Timetable = findViewById(R.id.img_TimeTable);
        tv_StudentName = findViewById(R.id.tv_StudentName);

        tv_StudentName.setText(user.getEmail());


        rl_TimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), TimeTable.class);
                startActivity(intent);
            }
        });
        rl_Class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ClassActivity.class);
                startActivity(intent);
            }
        });
        rl_Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                startActivity(intent);
            }
        });
        rl_Store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StoreActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (user == null){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

    }
}