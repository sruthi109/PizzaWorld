package com.example.pizzaworld;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pizzaworld.model.PojoDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class MyOrder extends Fragment {
    private List<PojoDetails> pojoDetails;
    ListView listView;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private  MyOrderAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_my_order, container, false);
        listView = root.findViewById(R.id.myorderlist);
        pojoDetails = new ArrayList<PojoDetails>();
        adapter = new MyOrderAdapter(getContext(),pojoDetails);
        listView.setAdapter(adapter);
        db.collection("AddToCart").whereEqualTo("userId", mAuth.getCurrentUser().getEmail()).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
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

        return  root;

    }
}