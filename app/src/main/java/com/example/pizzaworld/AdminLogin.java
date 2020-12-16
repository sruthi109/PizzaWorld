package com.example.pizzaworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AdminLogin extends AppCompatActivity {
    EditText email,password;
    Button bt_login_login;
    FirebaseAuth fAuth;
    String Pass;
    String e;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        email = findViewById(R.id.email);
        fAuth = FirebaseAuth.getInstance();
       password=findViewById(R.id.password);
        bt_login_login=findViewById(R.id.bt_login_login);


        db.collection("admin").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                  //  List<String> list = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                       // Log.d("", document.getId());
                        a= document.getData().get("admin").toString();
                        //Toast.makeText(AdminLogin.this,""+a,Toast.LENGTH_SHORT).show();

                        bt_login_login.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                e=email.getText().toString();
                                Pass = password.getText().toString();
                                Toast.makeText(AdminLogin.this,""+e,Toast.LENGTH_SHORT).show();
                                if(e.equals(a))
                                {

                                   fAuth.signInWithEmailAndPassword(e,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(AdminLogin.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(AdminLogin.this,AdminPanel.class));
                                            }else {
                                                Toast.makeText(AdminLogin.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                            }



                                        }
                                    });




                          //    Intent i=new Intent(AdminLogin.this,AdminPanel.class);
                          //    startActivity(i);
                                }

                                else{
                                    finish();
                                }


                            }
                        });



                    }
                }
            }
        });

        findViewById(R.id.user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminLogin.this,ClientLogin.class);
                  startActivity(i);

            }
        });
    }
}

