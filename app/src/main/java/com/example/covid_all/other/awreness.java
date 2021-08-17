package com.example.covid_all.other;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_all.R;

public class awreness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awreness);
    }

    public void awareness(View view) {
        Intent intent=new Intent(awreness.this,datashow.class);
        Log.e("tag","llalala");
        startActivity(intent);
    }

    public void news(View view) {
        Intent intent=new Intent(awreness.this,news.class);
        Log.e("tag","llalala");
        startActivity(intent);
    }
}