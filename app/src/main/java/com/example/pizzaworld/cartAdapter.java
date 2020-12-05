package com.example.pizzaworld;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaworld.model.PojoDetails;

import java.util.ArrayList;
import java.util.List;


public class cartAdapter extends BaseAdapter {

    List<PojoDetails> pojoDetails;
    Context context;
    public cartAdapter(Context context, List<PojoDetails> pojoDetails){
        super();
        this.pojoDetails=pojoDetails;
        this.context=context;

    }

    @Override
    public int getCount() {
        return pojoDetails.size();
    }

    @Override
    public PojoDetails getItem(int position)
    {
        return pojoDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder) convertView.getTag();
            //PojoDetails pojoDetails=getItem(position);

        }

        PojoDetails pojoDetails=getItem(position);
        viewHolder.name.setText(pojoDetails.getPizzaname());
        viewHolder.price.setText(pojoDetails.getPrice());
        viewHolder.quantity.setText(pojoDetails.getQuantuu());
        // Double pricuu= Double.valueOf(pojoDetails.getPrice());
        //  Double pricuu=0.0;
        // Double xyz= Double.parseDouble( viewHolder.price.getText().toString());



        return convertView;
    }

    class ViewHolder{
        TextView name,price,quantity;
        // ImageView movieImage;

        public ViewHolder(View view)
        {
            name=view.findViewById(R.id.pizza_name);
            price=view.findViewById(R.id.pizza_price);
            // movieImage=view.findViewById(R.id.imageViewMovie);
            quantity=view.findViewById(R.id.pizza_quantity);
        }
    }


}

