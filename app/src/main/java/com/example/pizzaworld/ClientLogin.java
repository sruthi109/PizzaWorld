package com.example.pizzaworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClientLogin extends AppCompatActivity {
    Button login,signup,forgotpassword,adminsign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);
        login=findViewById(R.id.btn_login);
        signup=findViewById(R.id.btn_signup);
        forgotpassword=findViewById(R.id.btn_forgotpassword);
        adminsign=findViewById(R.id.btn_admin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ClientLogin.this, MainActivity.class);
                startActivity(i);

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ClientLogin.this, ClientSignUp.class);
                startActivity(i);

            }
        });



        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent i = new Intent(ClientLogin.this, ForgotPassword.class);
                // startActivity(i);

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
