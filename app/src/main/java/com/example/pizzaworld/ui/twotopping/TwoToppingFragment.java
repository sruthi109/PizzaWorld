package com.example.pizzaworld.ui.twotopping;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pizzaworld.R;
import com.example.pizzaworld.Details;


public class TwoToppingFragment extends Fragment {

    ImageView vegPizza,pizzaHawaiian,meatpizza,chickenpizza,buffalopizza,margheritapizza;
    TextView priceVeg,pricehawaiian,priceMeat,priceChicken,buffaloprice,margheritaprice;
    TextView vegname,hawaiianname,Meatname,chickenname,buffaloname,margheritaname;



    public TwoToppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_two_topping, container, false);

        priceVeg=root.findViewById(R.id.priceveg);
        pricehawaiian=root.findViewById(R.id.pricehawaian);
        priceMeat=root.findViewById(R.id.pricemeat);
        priceChicken=root.findViewById(R.id.pricechicken);
        buffaloprice=root.findViewById(R.id.pricebuffalo);
        margheritaprice=root.findViewById(R.id.margheritapizzaprice);

        vegPizza=root.findViewById(R.id.pizzaveg);
        pizzaHawaiian=root.findViewById(R.id.pizzahawaian);
        meatpizza=root.findViewById(R.id.pizzameat);
        chickenpizza=root.findViewById(R.id.bbqchickenpizza);
        buffalopizza=root.findViewById(R.id.buffalopizza);
        margheritapizza=root.findViewById(R.id.margheritapizza);

        vegname=root.findViewById(R.id.Vegname);
        hawaiianname=root.findViewById(R.id.hawaianname);
        Meatname=root.findViewById(R.id.Meatname);
        chickenname=root.findViewById(R.id.chickenname);
        buffaloname=root.findViewById(R.id.buffaloname);
        margheritaname=root.findViewById(R.id.margheritapizzaname);


        vegPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=priceVeg.getText().toString();
                String name=vegname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.vegpizza);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        pizzaHawaiian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricehawaiian.getText().toString();
                String name=hawaiianname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.hawa);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        meatpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=priceMeat.getText().toString();
                String name=Meatname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.meatpizza);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        chickenpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=priceChicken.getText().toString();
                String name=chickenname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price", price);
                intent.putExtra("image",R.drawable.bbqchickenpizza);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        margheritapizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=margheritaprice.getText().toString();
                String name=margheritaname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.margheritapizza);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });


        buffalopizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=buffaloprice.getText().toString();
                String name=buffaloname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price", price);
                intent.putExtra("image",R.drawable.buffalopizza);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        return root;
    }
}
