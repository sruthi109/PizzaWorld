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
    ImageView coke_tin,bottle,flavouredwater,nestea,waterbottle,monster,brownies,specialitychicken,lava,wings,fries,poutine;
    TextView tinname,bottlename,sparklingname,nesteaname,watername,monstername,browniesname,specialityname,lavaname,wingsname,friesname,poutinename;
    TextView pricecoke,pricebottle,pricesparkling,pricenestea,pricewater,pricemonster,pricebrownies,pricespecialitychic,pricelava,pricewings,pricefries,pricepout;
    public ExtraFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_extra, container, false);

        pricecoke=root.findViewById(R.id.pricecoke);
        pricebottle=root.findViewById(R.id.pricebottle);
        pricesparkling=root.findViewById(R.id.pricesparkling);
        pricenestea=root.findViewById(R.id.pricenestea);
        pricewater=root.findViewById(R.id.pricewater);
        pricemonster=root.findViewById(R.id.pricemonster);
        pricebrownies=root.findViewById(R.id.pricebrownies);
        pricespecialitychic=root.findViewById(R.id.pricespecialitychic);
        pricelava=root.findViewById(R.id.pricelava);
        pricewings=root.findViewById(R.id.pricewings);
        pricefries=root.findViewById(R.id.pricefries);
        pricepout=root.findViewById(R.id.pricepout);



        coke_tin=root.findViewById(R.id.coke_tin);
        bottle=root.findViewById(R.id.bottle);
        flavouredwater=root.findViewById(R.id.flavouredwater);
        nestea=root.findViewById(R.id.nestea);
        waterbottle=root.findViewById(R.id.waterbottle);
        monster=root.findViewById(R.id.monster);
        brownies=root.findViewById(R.id.brownies);
        specialitychicken=root.findViewById(R.id.specialitychicken);
        lava=root.findViewById(R.id.lava);
        wings=root.findViewById(R.id.wings);
        fries=root.findViewById(R.id.fries);
        poutine=root.findViewById(R.id.poutine);


        tinname=root.findViewById(R.id.tinname);
        bottlename=root.findViewById(R.id.bottlename);
        sparklingname=root.findViewById(R.id.sparklingname);
        nesteaname=root.findViewById(R.id.nesteaname);
        watername=root.findViewById(R.id.watername);
        monstername=root.findViewById(R.id.monstername);
        browniesname=root.findViewById(R.id.browniesname);
        specialityname=root.findViewById(R.id.specialityname);
        lavaname=root.findViewById(R.id.lavaname);
        wingsname=root.findViewById(R.id.wingsname);
        friesname=root.findViewById(R.id.friesname);
        poutinename=root.findViewById(R.id.poutinename);

        coke_tin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricecoke.getText().toString();
                String name=tinname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.coke_tin);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricebottle.getText().toString();
                String name=bottlename.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.bottle_coke);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

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

        lava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricelava.getText().toString();
                String name=lavaname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.lava);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        wings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricewings.getText().toString();
                String name=wingsname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.chickenwingsss);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        fries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricefries.getText().toString();
                String name=friesname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.fries);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        poutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pricepout.getText().toString();
                String name=poutinename.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.poutine);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        return root;
    }
}
