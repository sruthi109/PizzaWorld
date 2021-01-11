package com.example.pizzaworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.pizzaworld.model.PojoDetails;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Delivered extends AppCompatActivity {
    private List<PojoDetails> pojoDetails;
    ListView listView;
    ImageView back;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DeliveredAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered);
        listView = findViewById(R.id.deliveredlist);
        back=findViewById(R.id.back);
        pojoDetails = new ArrayList<PojoDetails>();
        adapter = new DeliveredAdapter(this, pojoDetails);
        listView.setAdapter(adapter);
        db.collection("AddToCart").whereEqualTo("status", "Delivered").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : list) {
                        PojoDetails pDs = d.toObject(PojoDetails.class);

                        pDs.setId(d.getId());

                        pojoDetails.add(pDs);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Delivered.this,AdminPanel.class);
                startActivity(i);
            }
        });


    }




}