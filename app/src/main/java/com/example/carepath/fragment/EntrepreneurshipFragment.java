package com.example.carepath.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.carepath.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntrepreneurshipFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ent, container, false);
        TextView textView = root.findViewById(R.id.entre_txt);
        try {
            String line;
            InputStreamReader isr = new InputStreamReader(getResources().getAssets().open("Entre.txt"));
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            String data = stringBuilder.toString();
            textView.setText(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
