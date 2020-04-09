package com.example.carepath.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.carepath.R;
import com.example.carepath.activity.LoginUser;
import com.example.carepath.activity.MainActivity;
import com.example.carepath.session.Session;

public class SplashScreen extends AppCompatActivity {

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        session = new Session(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(session.logIn()){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(getApplicationContext(), LoginUser.class));
                    finish();
                }
            }
        }, 2000);
    }
}
