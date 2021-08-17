package com.example.covid_all;
import com.example.covid_all.tifin.*;
import com.example.covid_all.slot.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.covid_all.other.*;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();



    }

    public void itifin(View view) {
        Intent intent=new Intent(MainActivity.this,tifinM.class);
        Log.e("tag","llalala");
        startActivity(intent);

    }

    public void ihospital(View view) {
        Intent intent=new Intent(MainActivity.this,tifinM.class);
        Log.e("tag","llalala");
        startActivity(intent);

    }

    public void ifuneralcar(View view) {
        Intent intent=new Intent(MainActivity.this,tifinM.class);
        Log.e("tag","llalala");
        startActivity(intent);
    }

    public void imadicines(View view) {
        Intent intent=new Intent(MainActivity.this,tifinM.class);
        Log.e("tag","llalala");
        startActivity(intent);

    }

    public void logout(View view) {
        Intent intent=new Intent(MainActivity.this,tifinM.class);
        Log.e("tag","llalala");
        startActivity(intent);

    }

    public void toolmenu(View view) {
        Intent intent=new Intent(MainActivity.this,tifinM.class);
        Log.e("tag","llalala");
        startActivity(intent);

    }

    public void islot(View view) {
        Intent intent=new Intent(MainActivity.this,mainapi.class);
        Log.e("tag","llalala");
        startActivity(intent);
    }

    public void other(View view) {
        Intent intent=new Intent(MainActivity.this,awreness.class);
        Log.e("tag","llalala");
        startActivity(intent);
    }
}