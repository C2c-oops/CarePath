package com.example.carepath.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.carepath.R;
import com.example.carepath.fragment.Fragment1;
import com.example.carepath.fragment.Fragment2;

public class P5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5);

        Toolbar toolbar = findViewById(R.id.toolbar_answer3);
        //setSupportActionBar(toolbar);

        TextView frgmnt1 = findViewById(R.id.frgmnt1);
        TextView frgmnt2 = findViewById(R.id.frgmnt2);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment1()).commit();

        frgmnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment1()).commit();
            }
        });
        frgmnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment2()).commit();
            }
        });
    }
}