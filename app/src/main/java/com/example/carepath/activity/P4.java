package com.example.carepath.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carepath.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P4 extends AppCompatActivity {
    private static final String FILENAME = "Record";
    private StringBuilder sb;
    private BufferedReader br;
    private EditText value;
    private Button readbtn,writebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4);

        value = findViewById(R.id.value);
        readbtn = findViewById(R.id.readbtn);
        writebtn = findViewById(R.id.writebtn);

        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });

        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeData();
            }
        });


    }

    private void readData() {
        try {
            FileInputStream fis  =  this.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            sb = new StringBuilder();
            br  = new BufferedReader(isr);
            String line = br.readLine();
            while (line!=null){
                sb.append(line).append('\n');
                line = br.readLine();
            }
            String content = sb.toString();
            //this.value.setText(content);
            Toast.makeText(this, content, Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeData(){
        String value  = this.value.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = this.openFileOutput(FILENAME,MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(value);
            osw.close();
            Toast.makeText(this, "Data Written Successfully", Toast.LENGTH_SHORT).show();
            this.value.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}