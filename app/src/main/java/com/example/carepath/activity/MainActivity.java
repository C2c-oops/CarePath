package com.example.carepath.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.carepath.R;
import com.example.carepath.activity.LoginUser;
import com.example.carepath.session.Session;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button, button1, button2, button3;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        textView = findViewById(R.id.mainInfo);
        button = findViewById(R.id.mainButton);
        button1 = findViewById(R.id.activityP3);
        button2 = findViewById(R.id.activityP4);
        button3 = findViewById(R.id.activityP5);

        if(!session.logIn()){
            logout();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TabbedView.class));
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), P4.class));
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), P5.class));
                finish();
            }
        });
    }

    private void logout() {
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(this, LoginUser.class));
    }
}
