package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterUser extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        editText1 = findViewById(R.id.registerUserName);
        editText2 = findViewById(R.id.registerEmail);
        editText3 = findViewById(R.id.registerPassword);
        button = findViewById(R.id.registerButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                String newUser = editText1.getText().toString();
                String newEmail = editText2.getText().toString();
                String newPassword = editText3.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(newUser, newUser);
                editor.apply();
                editor.putString(newPassword, newPassword);
                editor.apply();
                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), LoginUser.class);
                startActivity(intent);
            }
        });
    }
}
