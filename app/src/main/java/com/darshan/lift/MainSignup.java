package com.darshan.lift;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class MainSignup extends AppCompatActivity {


    public static final String TAG = "TAG";
    EditText mFullname,mAuid,mPhoneno,mEmail,mPassword;
    Spinner mGender;
    Button mSignup;
    //ProgressBar mProgressbar;
    TextView mLogin;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);

        Spinner vehicle = (Spinner) findViewById(R.id.gender);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainSignup.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.gender));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicle.setAdapter(myAdapter);

        FirebaseAuth.getInstance().signOut();

        mFullname = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.email);
        mPhoneno = findViewById(R.id.phoneno);
        mPassword = findViewById(R.id.password);
        mGender =  findViewById(R.id.gender);
        mSignup = findViewById(R.id.signup);
        mAuid = findViewById(R.id.auid);
        mLogin = findViewById(R.id.login);
       // mProgressbar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),Chooseservice.class));
            finish();
        }

        mSignup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String fullName = mFullname.getText().toString();
                final String phone    = mPhoneno.getText().toString();
                final String auid = mAuid.getText().toString();
                final String gender = mGender.getSelectedItem().toString();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                if(TextUtils.isEmpty(auid)){
                    mAuid.setError("Aadhaar Card UID is Required.");
                    return;
                }

                if(auid.length() < 12){
                    mAuid.setError("Aadhar Card UID Must be of 12 Digits");
                    return;
                }

                if(TextUtils.isEmpty(phone)){
                    mPhoneno.setError("Phone Number is Required.");
                    return;
                }

                if(phone.length() < 10){
                    mPhoneno.setError("Phone Number Must be of 10 Digits");
                    return;
                }

                if(gender == "Select Gender"){
                    mAuid.setError("Please Select your Gender.");
                    return;
                }

                //mProgressbar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(MainSignup.this, "User Created.", Toast.LENGTH_LONG).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",fullName);
                            user.put("email",email);
                            user.put("phone",phone);
                            user.put("auid",auid);
                            user.put("gender",gender);

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),Chooseservice.class));

                        }else {
                            Toast.makeText(MainSignup.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            //mProgressbar.setVisibility(View.GONE);
                        }

                    }
                });


            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }


}
