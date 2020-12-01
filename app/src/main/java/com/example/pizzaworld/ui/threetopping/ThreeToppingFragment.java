package com.example.pizzaworld.ui.threetopping;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaworld.Details;
import com.example.pizzaworld.R;



public class ThreeToppingFragment extends Fragment {

    // LinearLayout firstlayout;
    ImageView pepperoniPizza,supremepizza,cheesepizza,workpizza,verdugopizza,mellowmushroompizza;
    TextView pepperoniprice,pricesupreme,cheeseprice,workprice,verdugopizzaprice,mellowmushroompizzaprice;
    TextView pepperoniname,supremename,cheesename,workname,verdugopizzaname,mellowmushroompizzaname;



    public ThreeToppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_three_topping, container, false);

        // firstlayout=root.findViewById(R.id.firstllayout);
        pepperoniprice=root.findViewById(R.id.pricepepporni);
        pricesupreme=root.findViewById(R.id.pricesupreme);
        cheeseprice=root.findViewById(R.id.pricecheese);
        workprice=root.findViewById(R.id.pricework);
        verdugopizzaprice=root.findViewById(R.id.priceverdugopizza);
        mellowmushroompizzaprice=root.findViewById(R.id.mellowmushroompizzaprice);


        pepperoniPizza=root.findViewById(R.id.pepporonipizza);
        supremepizza=root.findViewById(R.id.supremepizza);
        cheesepizza=root.findViewById(R.id.cheesepizza);
        workpizza=root.findViewById(R.id.workpizza);
        verdugopizza=root.findViewById(R.id.verdugopizza);
        mellowmushroompizza=root.findViewById(R.id.mellowmushroompizza);

        pepperoniname=root.findViewById(R.id.pepporoniName);
        supremename=root.findViewById(R.id.supremename);
        cheesename=root.findViewById(R.id.cheesename);
        workname=root.findViewById(R.id.workname);
        verdugopizzaname=root.findViewById(R.id.verdugopizzaname);
        mellowmushroompizzaname=root.findViewById(R.id.mellowmushroompizzaname);


        pepperoniPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pepperoniprice.getText().toString();
                String name=pepperoniname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.pepporonipizza);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        workpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=workprice.getText().toString();
                String name=workname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.workpizza);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        cheesepizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=cheeseprice.getText().toString();
                String name=cheesename.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.cheesepizza);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        supremepizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricesupreme.getText().toString();
                String name=supremename.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.supremepizza);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        verdugopizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=verdugopizzaprice.getText().toString();
                String name=verdugopizzaname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.verdugopizza);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        mellowmushroompizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=mellowmushroompizzaprice.getText().toString();
                String name=mellowmushroompizzaname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.mellowmushroom);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        return root;
    }


}
