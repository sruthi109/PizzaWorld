package com.example.pizzaworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaworld.model.PojoDetails;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class AddCart extends AppCompatActivity {
    Button cancel1;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listView;

    private cartAdapter adapter;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private List<PojoDetails> pojoDetails;

    //cartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);
        listView=findViewById(R.id.addcart);
        pojoDetails=new ArrayList<PojoDetails>();
        adapter=new cartAdapter(this,pojoDetails);
        listView.setAdapter(adapter);

        cancel1=findViewById(R.id.cancel1);
        cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent account = new Intent(AddCart.this, MainActivity.class);
                startActivity(account);

            }
        });

        db.collection("AddToCart").whereEqualTo("userId",mAuth.getCurrentUser().getEmail()).whereEqualTo("status","Cart").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(!queryDocumentSnapshots.isEmpty())
                {
                    List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                    for(DocumentSnapshot d: list){

                        PojoDetails pDs= d.toObject(PojoDetails.class);

                        pDs.setId(d.getId());



                        pojoDetails.add(pDs);

                    }

                    adapter.notifyDataSetChanged();


                }
            }
        });


        Toast.makeText(AddCart.this,"hello",Toast.LENGTH_SHORT).show();
    }


}