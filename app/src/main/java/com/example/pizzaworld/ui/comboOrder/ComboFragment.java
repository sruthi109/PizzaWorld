package com.example.pizzaworld.ui.comboOrder;

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


public class ComboFragment extends Fragment {

    ImageView chickenbites,wingit,pizzawithfries,largepizzawithdrinks,friesnuggets,pizzawithdippings;
    TextView chickenbitesname,wingitname,pizzawithfriesname,largepizzawithdrinksname,friesnuggetsname,pizzawithdippingsname;
    TextView chickenbitesprice,wingitprice,pizzawithfriesprice,largepizzawithdrinksprice,friesnuggetsprice,pizzawithdippingsprice;

    public ComboFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=  inflater.inflate(R.layout.fragment_combo, container, false);
        chickenbitesprice=root.findViewById(R.id.pricechickenbites);
        wingitprice=root.findViewById(R.id.pricewingit);
        pizzawithfriesprice=root.findViewById(R.id.pricepizzawithfries);
        largepizzawithdrinksprice=root.findViewById(R.id.pricelargepizzawithdrinks);
        friesnuggetsprice=root.findViewById(R.id.pricefriesnuggets);
        pizzawithdippingsprice=root.findViewById(R.id.pizzawithdippingsprice);


        chickenbites=root.findViewById(R.id.chickenbites);
        wingit=root.findViewById(R.id.wingit);
        pizzawithfries=root.findViewById(R.id.pizzawithfries);
        largepizzawithdrinks=root.findViewById(R.id.largepizzawithdrinks);
        friesnuggets=root.findViewById(R.id.friesnuggets);
        pizzawithdippings=root.findViewById(R.id.pizzawithdippings);



        chickenbitesname=root.findViewById(R.id.chickenbitesname);
        wingitname=root.findViewById(R.id.wingitname);
        pizzawithfriesname=root.findViewById(R.id.pizzawithfriesname);
        largepizzawithdrinksname=root.findViewById(R.id.largepizzawithdrinksname);
        friesnuggetsname=root.findViewById(R.id.friesnuggetsname);
        pizzawithdippingsname=root.findViewById(R.id.pizzawithdippingsname);

        chickenbites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=chickenbitesprice.getText().toString();
                String name=chickenbitesname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.chicken_bites);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        wingit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=wingitprice.getText().toString();
                String name=wingitname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.wingit);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        pizzawithfries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pizzawithfriesprice.getText().toString();
                String name=pizzawithfriesname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.pizzawithfires);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        largepizzawithdrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=largepizzawithdrinksprice.getText().toString();
                String name=largepizzawithdrinksname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.largepizzawithdrinks);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });


        friesnuggets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=friesnuggetsprice.getText().toString();
                String name=friesnuggetsname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.friesnuggets);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        pizzawithdippings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=pizzawithdippingsprice.getText().toString();
                String name=pizzawithdippingsname.getText().toString();
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("price",price);
                intent.putExtra("image",R.drawable.pizzawithdippings);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });





        return root;
    }
}
