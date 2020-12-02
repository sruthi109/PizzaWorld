package com.example.pizzaworld.ui.extra;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzaworld.Details;
import com.example.pizzaworld.R;


public class ExtraFragment extends Fragment {
    ImageView flavouredwater,nestea,waterbottle,monster,brownies,specialitychicken;
    TextView  sparklingname,nesteaname,watername,monstername,browniesname,specialityname;
    TextView  pricesparkling,pricenestea,pricewater,pricemonster,pricebrownies,pricespecialitychic;

    public ExtraFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_extra, container, false);
        pricesparkling=root.findViewById(R.id.pricesparkling);
        pricenestea=root.findViewById(R.id.pricenestea);
        pricewater=root.findViewById(R.id.pricewater);
        pricemonster=root.findViewById(R.id.pricemonster);
        pricebrownies=root.findViewById(R.id.pricebrownies);
        pricespecialitychic=root.findViewById(R.id.pricespecialitychic);



        flavouredwater=root.findViewById(R.id.flavouredwater);
        nestea=root.findViewById(R.id.nestea);
        waterbottle=root.findViewById(R.id.waterbottle);
        monster=root.findViewById(R.id.monster);
        brownies=root.findViewById(R.id.brownies);
        specialitychicken=root.findViewById(R.id.specialitychicken);


        sparklingname=root.findViewById(R.id.sparklingname);
        nesteaname=root.findViewById(R.id.nesteaname);
        watername=root.findViewById(R.id.watername);
        monstername=root.findViewById(R.id.monstername);
        browniesname=root.findViewById(R.id.browniesname);
        specialityname=root.findViewById(R.id.specialityname);


        flavouredwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricesparkling.getText().toString();
                String name=sparklingname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.sparkling_water);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        nestea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricenestea.getText().toString();
                String name=nesteaname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.nestea);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        waterbottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricewater.getText().toString();
                String name=watername.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.water_bottle);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        monster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricemonster.getText().toString();
                String name=monstername.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.monster);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        brownies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricebrownies.getText().toString();
                String name=browniesname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.marblebrownies);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        specialitychicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricespecialitychic.getText().toString();
                String name=specialityname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.speciality);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

       
        return root;
    }
}