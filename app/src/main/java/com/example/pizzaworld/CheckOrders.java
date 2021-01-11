package com.example.pizzaworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pizzaworld.model.PojoDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.WriteBatch;

import java.util.ArrayList;
import java.util.List;

public class   CheckOrders extends AppCompatActivity {
    ListView listView;
    ImageView back;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DeliveredAdapter adapter;
    String user;
    private List<PojoDetails> pojoDetails;
    // FirebaseAuth mAuth = FirebaseAuth.getInstance();
    TextView addresss,total_price;
    Button delivered,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_orders);
        listView=findViewById(R.id.orderslist);
        back=findViewById(R.id.back);
        user = getIntent().getExtras().getString("text");
        total_price=findViewById(R.id.total_price);
        addresss=findViewById(R.id.address);
        pojoDetails = new ArrayList<PojoDetails>();
        cancel=findViewById(R.id.cancel);
        delivered=findViewById(R.id.delivered);
        adapter = new DeliveredAdapter(this, pojoDetails);
        listView.setAdapter(adapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckOrders.this,AdminPanel.class );
                startActivity(intent);

            }
        });
        db.collection("AddToCart").whereEqualTo("userId",user ).whereEqualTo("status", "Ordered").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : list) {
                        PojoDetails pDs = d.toObject(PojoDetails.class);

                        pDs.setId(d.getId());
                        // total_price.setText(pDs.getTotalprice());
                        // addresss.setText(pDs.getAddress());

                        pojoDetails.add(pDs);

                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        delivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("AddToCart").whereEqualTo("userId", user).whereEqualTo("status", "Ordered").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Log.d("", document.getId());
                                list.add(document.getId());

                                //   pDs = document.toObject(PojoDetails.class);
                                //  pDs.setId(document.getId());
                                //  String documentid = pDs.getId().toString();
                                //  db.collection("AddOnCart").document().update("status",PojoDetails.getStatus(),"address" ,PojoDetails.getAddress(),"totalprice",PojoDetails.getTotalprice());
                                // Toast.makeText(activity_addcart.this,"Order is done",Toast.LENGTH_LONG).show();
                            }
                            Log.d("", list.toString());
                            updateData(list);
                        }
                    }

                    private void updateData(List<String> list) {
                        WriteBatch batch = db.batch();

                        // Iterate through the list
                        for (int k = 0; k < list.size(); k++) {

                            // Update each list item
                            DocumentReference ref = db.collection("AddToCart").document(list.get(k));
                            batch.update(ref,"status","Delivered" );

                        }


                        batch.commit().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });

                    }
                });

                AlertDialog.Builder builder = new AlertDialog.Builder(CheckOrders.this);
                builder.setMessage("The Order is Delivered Successfully")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(CheckOrders.this,AdminPanel.class );

                                startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                return;
                //  Intent intent = new Intent(CheckOrders.this,Delivered.class );

                // startActivity(intent);
            }


        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckOrders.this,AdminPanel.class );
                startActivity(intent);
            }
        });


    }

}