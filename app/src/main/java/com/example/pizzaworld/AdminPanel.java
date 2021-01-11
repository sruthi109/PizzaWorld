package com.example.pizzaworld;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaworld.model.PojoDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.reflect.TypeToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AdminPanel extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<PojoDetails> pojoDetails;
    private List<PojoDetails> pojoDetailsFiltered;
    // private List<PojoDetails> list;
    private AdminPanelAdapter adapter;
    ListView listView;
    PojoDetails p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Toolbar toolbar = findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);
        setContentView(R.layout.activity_admin_panel);
        listView=findViewById(R.id.listu);
        //  pojoDetails = new ArrayList<PojoDetails>();
        pojoDetails = new ArrayList<PojoDetails>();
        pojoDetailsFiltered = new ArrayList<PojoDetails>();
        adapter = new AdminPanelAdapter(this, pojoDetailsFiltered);
        listView.setAdapter(adapter);
        db.collection("AddToCart").whereEqualTo("status", "Ordered").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    //List<String> list = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {

                        Log.d("", document.getId());
                        p= (document.toObject(PojoDetails.class));


                        pojoDetails.add(p);
                        for(PojoDetails Poj: pojoDetails){
                            boolean isFound= false;
                            for(PojoDetails po: pojoDetailsFiltered){
                                if (po.getUserId().equals(Poj.getUserId())||(po.equals((Poj)))){
                                    isFound=true;
                                    break;
                                }
                            }
                            if(!isFound) pojoDetailsFiltered.add(Poj);
                        }




                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.username);
                String text = textView.getText().toString();
                Intent intent = new Intent(AdminPanel.this,CheckOrders.class );
                intent.putExtra("text",text);

                startActivity(intent);






            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.adminmenu, menu);
        return true;
    }
    public void logout(MenuItem item) {
        FirebaseAuth.getInstance().signOut();//logoutg
        startActivity(new Intent(AdminPanel.this,AdminLogin.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delivered:
                Intent account = new Intent(AdminPanel.this, Delivered.class);
                startActivity(account);
                break;
           /* case R.id.action_settings:
                Intent i = new Intent(AdminPanel.this,AdminLogin.class);
                startActivity(i);
                break;

            */

        }
        return super.onOptionsItemSelected(item);
    }
}