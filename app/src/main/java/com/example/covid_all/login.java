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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class login extends AppCompatActivity {

    private FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView textView,textView1,forgot,singin;
    Button button;
    ImageView google,facebook;
    ProgressDialog progressDialog;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView=findViewById(R.id.inputEmail);
        textView1=findViewById(R.id.inputPassword);
        forgot=findViewById(R.id.forgotPassword);
        singin=findViewById(R.id.gotoRegister);

        button=findViewById(R.id.btnLogin);

        google=findViewById(R.id.googleLogin);
        facebook=findViewById(R.id.facebookLogin);

        progressDialog=new ProgressDialog(login.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're Creating your Account..");


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("User");

        auth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.signInWithEmailAndPassword(textView.getText().toString(),textView1.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                        if (task.isSuccessful()){

                            Intent inten=new Intent(login.this,MainActivity.class);
                            Log.e("tag","google");
                            startActivity(inten);
                        }
                        else {
                            Toast.makeText(login.this, Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_LONG).show();


                        }
                    }
                });

            }
        });
        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,sign_in.class);
                startActivity(intent);
            }
        });
        if (auth.getCurrentUser()!=null){
            Intent intent=new Intent(login.this,MainActivity.class);
            startActivity(intent);
        }
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }



    int RC_SIGN_IN=69;
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("Tag", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("tag", "Google sign in failed", e);
            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("tag", "signInWithCredential:success");

                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = auth.getCurrentUser();
//                            updateUI(user);
                            Intent inte=new Intent(login.this,MainActivity.class);
                            startActivity(inte);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e("tag", "signInWithCredential:failure", task.getException());
//                            updateUI(null);
                        }
                    }
                });
    }
}