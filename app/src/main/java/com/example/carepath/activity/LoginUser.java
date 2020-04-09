package com.example.carepath.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carepath.R;
import com.example.carepath.helper.DbHelper;
import com.example.carepath.session.Session;

public class LoginUser extends AppCompatActivity {

    EditText editText1, editText2;
    Button button1, button2;
    DbHelper db;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        db = new DbHelper(this);
        session = new Session(this);

        editText1 = findViewById(R.id.loginUsername);
        editText2 = findViewById(R.id.loginPassword);
        button1 = findViewById(R.id.loginButton1);
        button2 = findViewById(R.id.loginButton2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginUser.this, RegisterUser.class));
                finish();
            }
        });
    }

    private void login() {
        String username = editText1.getText().toString();
        String password = editText2.getText().toString();

        if(db.getUser(username, password)){
            session.setLoggedIn(true);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }else{
            Toast.makeText(this, "Wrong Username/password", Toast.LENGTH_SHORT).show();
        }
    }
}
