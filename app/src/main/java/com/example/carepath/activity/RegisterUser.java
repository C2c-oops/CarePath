package com.example.carepath.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carepath.R;
import com.example.carepath.activity.LoginUser;
import com.example.carepath.helper.DbHelper;

public class RegisterUser extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button button;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        db = new DbHelper(this);
        editText1 = findViewById(R.id.registerUserName);
        editText2 = findViewById(R.id.registerEmail);
        editText3 = findViewById(R.id.registerPassword);
        button = findViewById(R.id.registerButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register() {
        String username = editText1.getText().toString();
        String email = editText2.getText().toString();
        String password = editText3.getText().toString();

        if(username.isEmpty() && password.isEmpty()){
            displayToast("Username/password field empty");
        }else{
            db.addUser(username, email, password);
            displayToast("User Registered");
            startActivity(new Intent(this, LoginUser.class));
            finish();
        }
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
