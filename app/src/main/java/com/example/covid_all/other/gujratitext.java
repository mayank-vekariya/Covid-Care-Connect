package com.example.covid_all.other;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_all.R;

public class gujratitext extends AppCompatActivity {
    TextView textView;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gujratitext);

        textView=findViewById(R.id.gujarati_data);

        Intent intent=getIntent();
        data=intent.getStringExtra("gujudata");
        textView.setText(data);
    }
}