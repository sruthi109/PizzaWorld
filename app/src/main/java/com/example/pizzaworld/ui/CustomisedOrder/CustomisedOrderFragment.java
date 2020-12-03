package com.example.pizzaworld.ui.CustomisedOrder;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.pizzaworld.Details;
import com.example.pizzaworld.R;


public class CustomisedOrderFragment extends Fragment {
    CheckBox baseRegular,baseThin,basePan;
    CheckBox baseSmall,baseMedium,baseLarge;
    CheckBox baseSauceRegular,baseSauceRanch,baseSauceGarlic;
    CheckBox baseCheeseRegular,baseChesseCheddarmoz,basecheeseAmerican;
    CheckBox meatBacon,meatBeef,meatChicken,meatHam,meatPepproni,meatSausage,meatSteak;
    CheckBox greenPepper,pineApple,mushroom,onion,bananaPepper,blackOlives,greenOlives;
    String pizzabase, pizzasize,pizzasauce,pizzacheese,Bacon,Beef,Chicken,Ham,Pepperoni,Sausage,Steak,
            GreenPepper,PineApple,Mushroom,Onion,Bananapepper,BlackOlives,GreenOlives;
    Button customisedPizza;
    Double xyzprice=0.0;
    Double baseregprice=0.0,basethinprice=0.0,basepanprice=0.0,basesmallprice=0.0,basemediumprice=0.0,baselargeprice=0.0,cheeseprice=0.0,cheddarprice=0.0,americaprice=0.0,
            baconprice=0.0,beefprice=0.0,chickenprice=0.0,hamprice=0.0,pepproniprice=0.0,sausageprice=0.0,steakprice=0.0,greenpepprice=0.0,pineprice=0.0,mushprice=0.0,oniprice=0.0,bananaprice=0.0,blackprice=0.0,greenprice=0.0;
    public CustomisedOrderFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_customised_order, container, false);
        customisedPizza=root.findViewById(R.id.customisedPizza);
        greenPepper=root.findViewById(R.id.greenPepper);
        pineApple=root.findViewById(R.id.pineApple);
        mushroom=root.findViewById(R.id.mushroom);
        onion=root.findViewById(R.id.onion);
        bananaPepper=root.findViewById(R.id.bananaPepper);
        blackOlives=root.findViewById(R.id.blackOlives);
        greenOlives=root.findViewById(R.id.greenOlives);


        meatBacon=root.findViewById(R.id.meatBacon);
        meatBeef=root.findViewById(R.id.meatBeef);
        meatChicken=root.findViewById(R.id.meatChicken);
        meatHam=root.findViewById(R.id.meatHam);
        meatPepproni=root.findViewById(R.id.meatPepproni);
        meatSausage=root.findViewById(R.id.meatSausage);
        meatSteak=root.findViewById(R.id.meatSteak);

        baseRegular=root.findViewById(R.id.baseRegular);
        baseThin=root.findViewById(R.id.baseThin);
        basePan=root.findViewById(R.id.basePan);

        baseSmall=root.findViewById(R.id.baseSmall);
        baseMedium=root.findViewById(R.id.baseMedium);
        baseLarge=root.findViewById(R.id.baseLarge);

        baseSauceRegular=root.findViewById(R.id. baseSauceRegular);
        baseSauceRanch=root.findViewById(R.id.baseSauceRanch);
        baseSauceGarlic=root.findViewById(R.id.baseSauceGarlic);

        baseCheeseRegular=root.findViewById(R.id.baseCheeseRegular);
        baseChesseCheddarmoz=root.findViewById(R.id.baseChesseCheddarmoz);
        basecheeseAmerican=root.findViewById(R.id.basecheeseAmerican);

//select base type
        if(baseRegular.isChecked()){
            baseRegular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseRegular.setChecked(false);
                    baseregprice=0.0;
                    return;
                }
            });
        }
        if (!baseRegular.isChecked()) {
            baseRegular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseRegular.setChecked(true);
                    baseThin.setChecked(false);
                    basePan.setChecked(false);
                    pizzabase = "Regular";
                    baseregprice=4.0;
                }
            });
        }
        if(baseThin.isChecked()){
            baseThin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseThin.setChecked(false);
                    basethinprice=0.0;
                    return;
                }
            });
        }
        if (!baseThin.isChecked()){
            baseThin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseThin.setChecked(true);
                    basePan.setChecked(false);
                    baseRegular.setChecked(false);
                    pizzabase="Thin";
                    basethinprice=5.50;
                }
            });


        }
        if(basePan.isChecked()){
            basePan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    basePan.setChecked(false);
                    basepanprice=0.0;
                    return;
                }
            });
        }
        if (!basePan.isChecked()) {
            basePan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    basePan.setChecked(true);
                    baseRegular.setChecked(false);
                    baseThin.setChecked(false);
                    pizzabase = "Pan";
                    basepanprice=7.0;
                }
            });
        }

        //select base size
        if( baseSmall.isChecked()){
            baseSmall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseSmall.setChecked(false);
                    basesmallprice=0.0;
                    return;
                }
            });
        }
        if (! baseSmall.isChecked()) {
            baseSmall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseSmall.setChecked(true);
                    baseMedium.setChecked(false);
                    baseLarge.setChecked(false);
                    pizzasize="Small";
                    basesmallprice=0.5;

                }
            });
        }
        if(baseMedium.isChecked()){
            baseMedium.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseMedium.setChecked(false);
                    basemediumprice=0.0;
                    return;
                }
            });
        }
        if (!baseMedium.isChecked()){
            baseMedium.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseMedium.setChecked(true);
                    baseLarge.setChecked(false);
                    baseSmall.setChecked(false);
                    pizzasize="Medium";
                    basemediumprice=1.0;

                }
            });


        }
        if(baseLarge.isChecked()){
            baseLarge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseLarge.setChecked(false);
                    baselargeprice=0.0;
                    return;
                }
            });
        }
        if (!baseLarge.isChecked()) {
            baseLarge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseLarge.setChecked(true);
                    baseSmall.setChecked(false);
                    baseMedium.setChecked(false);
                    baselargeprice=1.25;
                    pizzasize="Large";
                }
            });
        }

        // select base sauce
        if(baseSauceRegular.isChecked()){
            baseSauceRegular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseSauceRegular.setChecked(false);
                    return;
                }
            });
        }
        if (!baseSauceRegular.isChecked()) {
            baseSauceRegular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseSauceRegular.setChecked(true);
                    baseSauceRanch.setChecked(false);
                    baseSauceGarlic.setChecked(false);
                    pizzasauce="Regular";

                }
            });
        }
        if( baseSauceRanch.isChecked()){
            baseSauceRanch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseSauceRanch.setChecked(false);
                    return;
                }
            });
        }
        if (! baseSauceRanch.isChecked()){
            baseSauceRanch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseSauceRanch.setChecked(true);
                    baseSauceGarlic.setChecked(false);
                    baseSauceRegular.setChecked(false);
                    pizzasauce="Ranch";

                }
            });


        }
        if( baseSauceGarlic.isChecked()){
            baseSauceGarlic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseSauceGarlic.setChecked(false);
                    return;
                }
            });
        }
        if (! baseSauceGarlic.isChecked()) {
            baseSauceGarlic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseSauceGarlic.setChecked(true);
                    baseSauceRegular.setChecked(false);
                    baseSauceRanch.setChecked(false);
                    pizzasauce="Garlic";

                }
            });
        }

        // select base cheese
        if( baseCheeseRegular.isChecked()){
            baseCheeseRegular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseCheeseRegular.setChecked(false);
                    cheeseprice=0.0;
                    return;
                }
            });
        }
        if (!baseCheeseRegular.isChecked()) {
            baseCheeseRegular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseCheeseRegular.setChecked(true);
                    baseChesseCheddarmoz.setChecked(false);
                    basecheeseAmerican.setChecked(false);
                    pizzacheese="Regular";
                    cheeseprice=3.0;

                }
            });
        }
        if( baseChesseCheddarmoz.isChecked()){
            baseChesseCheddarmoz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseChesseCheddarmoz.setChecked(false);
                    cheddarprice=0.0;
                    return;
                }
            });
        }
        if (! baseChesseCheddarmoz.isChecked()){
            baseChesseCheddarmoz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseChesseCheddarmoz.setChecked(true);
                    basecheeseAmerican.setChecked(false);
                    baseCheeseRegular.setChecked(false);
                    pizzacheese="Cheddar/mozzarella";
                    cheddarprice=5.25;

                }
            });


        }
        if( basecheeseAmerican.isChecked()){
            basecheeseAmerican.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    basecheeseAmerican.setChecked(false);
                    americaprice=0.0;
                    //return;
                }
            });
        }
        if (! basecheeseAmerican.isChecked()) {
            basecheeseAmerican.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    basecheeseAmerican.setChecked(true);
                    baseCheeseRegular.setChecked(false);
                    baseChesseCheddarmoz.setChecked(false);
                    pizzacheese="American-Cheese";
                    americaprice=6.50;

                }
            });
        }




        customisedPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!baseRegular.isChecked()&&!baseThin.isChecked()&&!basePan.isChecked())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Select a Pizza Base")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return;
                }
                if (!baseSmall.isChecked()&&!baseMedium.isChecked()&&!baseLarge.isChecked())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Select a Pizza Size")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return;
                }
                if (!baseCheeseRegular.isChecked()&&!basecheeseAmerican.isChecked()&&!baseChesseCheddarmoz.isChecked())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Select Base-Cheese for Pizza")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return;
                }
                if (!baseSauceRegular.isChecked()&&!baseSauceGarlic.isChecked()&&!baseSauceRanch.isChecked())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Select Base Sauce for Pizza")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return;
                }


                //select meat type
                if(!meatBacon.isChecked())
                {
                    meatBacon.setChecked(false);
                    Bacon="No";
                    baconprice=0.0;

                }
                else {

                    meatBacon.setChecked(true);
                    Bacon="Yes";
                    baconprice=0.99;

                }



                if(!meatBeef.isChecked())
                {
                    meatBeef.setChecked(false);
                    Beef="No";
                    beefprice=0.0;

                }
                else {

                    meatBeef.setChecked(true);
                    Beef="Yes";
                    beefprice=0.99;

                }
                if(!meatChicken.isChecked()){

                    meatChicken.setChecked(false);
                    Chicken="No";
                    chickenprice=0.0;

                }
                else {

                    meatChicken.setChecked(true);
                    Chicken="Yes";
                    chickenprice=0.99;

                }
                if(!meatHam.isChecked()){

                    meatHam.setChecked(false);
                    Ham="No";
                    hamprice=0.0;

                }
                else  {

                    meatHam.setChecked(true);
                    Ham="Yes";
                    hamprice=0.99;


                }
                if(!meatPepproni.isChecked()){

                    meatPepproni.setChecked(false);
                    Pepperoni="No";
                    pepproniprice=0.0;

                }
                else {

                    meatPepproni.setChecked(true);
                    Pepperoni="Yes";
                    pepproniprice=0.99;


                }
                if(!meatSausage.isChecked()){

                    meatSausage.setChecked(false);
                    Sausage="No";
                    sausageprice=0.0;

                }
                else {

                    meatSausage.setChecked(true);
                    Sausage="Yes";
                    sausageprice=0.99;

                }
                if(!meatSteak.isChecked()){

                    meatSteak.setChecked(false);
                    Steak="No";
                    steakprice=0.0;

                }
                else {

                    meatSteak.setChecked(true);
                    Steak="Yes";
                    steakprice=0.99;


                }
//select veggies
                if(!greenPepper.isChecked()){

                    greenPepper.setChecked(false);
                    GreenPepper="No";
                    greenpepprice=0.0;

                }
                else {

                    greenPepper.setChecked(true);
                    GreenPepper="Yes";
                    greenpepprice=0.75;


                }
                if(!pineApple.isChecked()){

                    pineApple.setChecked(false);
                    PineApple="No";
                    pineprice=0.0;

                }
                else {

                    pineApple.setChecked(true);
                    PineApple="Yes";
                    pineprice=0.75;


                }
                if(!mushroom.isChecked()){

                    mushroom.setChecked(false);
                    Mushroom="No";
                    mushprice=0.0;
                }


                else {

                    mushroom.setChecked(true);
                    Mushroom="Yes";
                    mushprice=0.75;


                }
                if(!onion.isChecked()){

                    onion.setChecked(false);
                    Onion="No";
                    oniprice=0.0;

                }
                else{

                    onion.setChecked(true);
                    Onion="Yes";
                    oniprice=0.75;

                }
                if(!bananaPepper.isChecked()){

                    bananaPepper.setChecked(false);
                    Bananapepper="No";
                    bananaprice=0.0;

                }
                else {

                    bananaPepper.setChecked(true);
                    Bananapepper="Yes";
                    bananaprice=0.75;

                }

                if(!blackOlives.isChecked()){

                    blackOlives.setChecked(false);
                    BlackOlives="No";
                    blackprice=0.0;

                }
                else {

                    blackOlives.setChecked(true);
                    BlackOlives="Yes";
                    blackprice=0.75;


                }
                if(!greenOlives.isChecked()){


                    greenOlives.setChecked(false);
                    GreenOlives="No";
                    greenprice=0.0;


                }
                else {

                    greenOlives.setChecked(true);
                    GreenOlives="Yes";
                    greenprice=0.75;


                }
                xyzprice  = baseregprice + basethinprice + basepanprice + basesmallprice + basemediumprice + baselargeprice + cheeseprice + cheddarprice + americaprice +
                        baconprice + beefprice + chickenprice + hamprice + pepproniprice + sausageprice + steakprice + greenpepprice + pineprice + mushprice + oniprice + bananaprice + blackprice + greenprice;
                Toast.makeText(getActivity(),""+xyzprice,Toast.LENGTH_LONG).show();
                String price= String.valueOf(xyzprice);

                String name="Customised Pizza";
                String disCusto="Pizza Base - " +pizzabase+","+"\n"+"Pizza Size - "+pizzasize+","+"\n"+"Pizza Sauce - "+pizzasauce+","+"\n"+"Base Cheese -"+pizzacheese+","+"\n"+
                        "Bacon - "+Bacon+","+"\n"+"Beef - "+Beef+","+"\n"+"Chicken - "+Chicken+","+"\n"+"Ham -"+Ham+","+"\n"+
                        "Pepperoni "+Pepperoni+","+"\n"+"Sausage - "+Sausage+","+"\n"+"Steak - "+Steak+","+"\n"+"Green Pepper-"+GreenPepper+","+"\n"+
                        "Pine Apple - "+PineApple+","+"\n"+"Mushroom - "+Mushroom+","+"\n"+"Onion - "+Onion+","+"\n"+"Black Olives -"+BlackOlives+","+"\n"+
                        "Banana Pepper - "+Bananapepper+","+"\n"+"Green Olives- "+GreenOlives+".";
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price", price);
                intent.putExtra("image",R.drawable.custo);
                intent.putExtra("name",name);
                intent.putExtra("disCusto",disCusto);
                startActivity(intent);
            }
        });





        return root;
    }



}