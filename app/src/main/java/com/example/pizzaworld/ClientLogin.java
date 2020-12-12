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

public class ClientLogin extends AppCompatActivity {
    Button login,signup,adminsign;
    EditText Email,Password;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.btn_login);

        adminsign=findViewById(R.id.btn_admin);
        signup=findViewById(R.id.btn_signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Email.setError("Please Enter The Email.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Password.setError("Please Enter the Password.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // authenticate the user

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ClientLogin.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(ClientLogin.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });


            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ClientLogin.this, ClientSignUp.class);
                startActivity(i);

            }
        });

        adminsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ClientLogin.this, AdminLogin.class);
                startActivity(i);


            }
        });


    }
}