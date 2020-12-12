package com.example.pizzaworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.google.firebase.firestore.Source;
import com.google.firebase.firestore.WriteBatch;

import java.util.ArrayList;
import java.util.List;

import static com.example.pizzaworld.Storage.*;


public class AddCart extends AppCompatActivity {
    Button cancel1,payment;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listView;
    Double s=0.0;
    Double x=0.0;
    private cartAdapter adapter;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private List<PojoDetails> pojoDetails;
    private static TextView total_price;
    PojoDetails  pDs;
    EditText addresss;

    //cartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);
        listView = findViewById(R.id.addcart);
        payment=findViewById(R.id.payment);
        total_price = findViewById(R.id.total_price);
        addresss=findViewById(R.id.address);
        pojoDetails = new ArrayList<PojoDetails>();
        adapter = new cartAdapter(this, pojoDetails);
        listView.setAdapter(adapter);

        cancel1 = findViewById(R.id.cancel1);
        cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent account = new Intent(AddCart.this, MainActivity.class);
                startActivity(account);

            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddCart.this,"Order Placed Successfully",Toast.LENGTH_LONG).show();
                String status="Ordered";
                final String address=addresss.getText().toString();
                String totalprice=total_price.getText().toString();


                db.collection("AddToCart").whereEqualTo("userId", mAuth.getCurrentUser().getEmail()).whereEqualTo("status", "Cart").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Log.d("", document.getId());
                                list.add(document.getId());


                            }
                            Log.d("", list.toString());
                            updateData(list);
                        }
                    }
                });


            }
        });

        db.collection("AddToCart").whereEqualTo("userId", mAuth.getCurrentUser().getEmail()).whereEqualTo("status", "Cart").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : list) {
                        pDs = d.toObject(PojoDetails.class);

                        pDs.setId(d.getId());


                        pojoDetails.add(pDs);

                        Storage.abc.add(pDs.getPrice().substring(1));


                    }

                    adapter.notifyDataSetChanged();

                    for (int i = Storage.abc.size()-1;i>=0;i=i-1)
                    {
                        s= Double.parseDouble(Storage.abc.get(i));
                        //+Double.parseDouble(abc.get(i-1));
                        x=x+s;



                    }


                    total_price.setText("$"+x.toString());
                    abc.clear();


                }


            }



        });





    }

    private void updateData(List<String> list) {
        WriteBatch batch = db.batch();

        // Iterate through the list
        for (int k = 0; k < list.size(); k++) {

            // Update each list item
            DocumentReference ref = db.collection("AddToCart").document(list.get(k));
            batch.update(ref, "address", addresss.getText().toString());
            batch.update(ref,"status","Ordered" );
            batch.update(ref,"totalprice",total_price.getText().toString());

        }


        batch.commit().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });

    }

}