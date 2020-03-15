package com.darshan.lift;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button mLogin;
    TextView mSignup;
    ProgressBar mProgressbar;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mProgressbar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        mLogin = findViewById(R.id.login);
        mSignup = findViewById(R.id.signup);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String password = mPassword.getText().toString().trim();
                final String email    = mEmail.getText().toString();


                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Phone Number is Required.");
                    return;
                }


                mProgressbar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            mProgressbar.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this, "Logegd in Successfully.", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),Chooseservice.class));
                        }else {
                            Toast.makeText(MainActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            mProgressbar.setVisibility(View.GONE);
                        }
                    }
                });
            }

        });

        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressbar.setVisibility(View.GONE);
                startActivity(new Intent(getApplicationContext(),MainSignup.class));
            }
        });

    }


}
