package com.example.covid_all;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class sign_in extends AppCompatActivity {
    private FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView textView,textView1,textView2,singup;
    Button button;
    ImageView google,facebook;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        textView=findViewById(R.id.inputEmail);
        textView1=findViewById(R.id.inputPassword);
        textView2=findViewById(R.id.inputconformPassword);
        singup=findViewById(R.id.gotoRegister);

        button=findViewById(R.id.btnLogin);

        google=findViewById(R.id.googleLogin);
        facebook=findViewById(R.id.facebookLogin);

        progressDialog=new ProgressDialog(sign_in.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Login In Your Account..");

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference("User");

        auth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(textView.getText().toString(),textView1.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    progressDialog.dismiss();
                                    Toast.makeText(sign_in.this,"User Created Successfully",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(sign_in.this, Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_LONG).show();


                                }
                            }
                        });

            }

        });

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(sign_in.this,login.class);
                Log.e("tag","llalala");
                startActivity(intent);
            }
        });

    }
}