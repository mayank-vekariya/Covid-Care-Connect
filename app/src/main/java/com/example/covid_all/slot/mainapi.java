package com.example.covid_all.slot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covid_all.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class mainapi extends AppCompatActivity {
    AutoCompleteTextView datacity,datapincode,recity,repncode;
    String[] ss={"one","two","three"};
    ArrayAdapter<String> arrayAdapter;
    EditText phonenumber;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String datac,datap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainapi);

        getSupportActionBar().hide();
        datacity=findViewById(R.id.v_city);
        datapincode=findViewById(R.id.v_punco);
        phonenumber=findViewById(R.id.editTextTextPersonName2);
        recity=findViewById(R.id.autoCompleteTextView);
        repncode=findViewById(R.id.punco);

        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,ss);

        datacity.setThreshold(1);
        datacity.setAdapter(arrayAdapter);

        datac=String.valueOf(datacity);
        datap=String.valueOf(datapincode);

        database = FirebaseDatabase.getInstance();

    }

    public void datacity(View view) {
        Intent intent=new Intent(mainapi.this,apicall.class);
//        intent.putExtra("gujudata",datac);
        Log.e("tag","llalala");
        startActivity(intent);


    }

    public void datapincode(View view) {
        Intent intent=new Intent(mainapi.this,pinapicall.class);
//        intent.putExtra("gujudata",datap);
        Log.e("tag","llalala");
        startActivity(intent);
    }

    public void recity(View view) {
        myRef = database.getReference("dis");
        String key=myRef.push().getKey();
        String pnumber=phonenumber.getText().toString();
        String city=recity.getText().toString();

        Map<String,Object> req=new HashMap<>();
        req.put("phone",pnumber);
        req.put("city",city);


        myRef.child(key).setValue(req);
        Toast.makeText(mainapi.this,"will be send you message in phone number",Toast.LENGTH_LONG).show();
    }

    public void repincode(View view) {
        myRef = database.getReference("pincode");
        String key=myRef.push().getKey();
        String pnumber=phonenumber.getText().toString();
        String pincode=repncode.getText().toString();

        Map<String,Object> req=new HashMap<>();
        req.put("phone",pnumber);
        req.put("pincode",pincode);
        myRef.child(key).setValue(req);
        Toast.makeText(mainapi.this,"will be send you message in phone number",Toast.LENGTH_LONG).show();
    }
}