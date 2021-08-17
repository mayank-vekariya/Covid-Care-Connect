package com.example.covid_all;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(splashscreen.this,login.class);
                    Log.e("tag","llalala");
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();

    }
}