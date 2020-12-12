package com.example.pizzaworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ClientSignUp extends AppCompatActivity {
    EditText FirstName,LastName,email,mobile,password;
    Button login, signup;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_sign_up);
        FirstName=findViewById(R.id.firstName);
        LastName=findViewById(R.id.lastName);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.mobile);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);


        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    email.setError("Email is required.");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    password.setError("password is required.");
                    return;
                }
                if(password.length()<6){
                    password.setError("Password must be>=6 Characters");
                    return;
                }
                if(mobile.length()<10){
                    mobile.setError("Invalid number");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ClientSignUp.this,"User Created",Toast.LENGTH_SHORT).show() ;
                            startActivity(new Intent(getApplicationContext(),ClientLogin.class));}
                        else
                        {
                            Toast.makeText(ClientSignUp.this,"Error !!.."+ task.getException().getMessage(),Toast.LENGTH_SHORT).show() ;
                        }
                    }
                });
            }



        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ClientLogin.class));
            }
        });


    }
}