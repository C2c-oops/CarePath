package com.example.carepath.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.carepath.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HigherStudiesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frgament_study, container, false);

        TextView textView = view.findViewById(R.id.higher_txt);

        try {
            String line;
            InputStreamReader isr = new InputStreamReader(getResources().getAssets().open("ResDeg.txt"));
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            String data = stringBuilder.toString();
            textView.setText(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }
}
