package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginUser extends AppCompatActivity {

    EditText editText1, editText2;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        editText1 = findViewById(R.id.loginUserName);
        editText2 = findViewById(R.id.loginPassword);
        button1 = findViewById(R.id.loginButton1);
        button2 = findViewById(R.id.loginButton2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText1.getText().toString();
                String password = editText2.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

                String userDetails = sharedPreferences.getString(user + password + "data", "Username or password is incorrect.");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("display", userDetails);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterUser.class);
                startActivity(intent);
            }
        });
    }
}
