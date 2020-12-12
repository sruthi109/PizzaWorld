package com.example.pizzaworld.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.pizzaworld.R;

public class HomeFragment extends Fragment   {

    private HomeViewModel homeViewModel;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TextView texttwo=root.findViewById(R.id.texttwo);
        TextView textthree=root.findViewById(R.id.textthree);
        TextView textcombo=root.findViewById(R.id.textcombo);
        TextView textcustomised=root.findViewById(R.id.textcusto);
        TextView textextra=root.findViewById(R.id.textextra);

        texttwo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_two_topping);



            }});

        textthree.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_three_topping);


            }});
        textcustomised.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_customised);
                //
                // Intent i=new Intent(getActivity(), MainActivity2.class);
                // startActivity(i);
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();

            }});
        textcombo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_combo);
                //
                // Intent i=new Intent(getActivity(), MainActivity2.class);
                // startActivity(i);
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();

            }});
        textextra.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_extra);
                //
                // Intent i=new Intent(getActivity(), MainActivity2.class);
                // startActivity(i);
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();

            }});


        return  root;
    }





}