package com.example.pizzaworld;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzaworld.model.PojoDetails;

import java.util.List;

public class MyOrderAdapter extends BaseAdapter {

    List<PojoDetails> pojoDetails;
    Context context;
    public MyOrderAdapter(Context context, List<PojoDetails> pojoDetails){
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
        com.example.pizzaworld.MyOrderAdapter.ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.myorderitems,null);
            viewHolder=new com.example.pizzaworld.MyOrderAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(com.example.pizzaworld.MyOrderAdapter.ViewHolder) convertView.getTag();
            //PojoDetails pojoDetails=getItem(position);

        }

        PojoDetails pojoDetails=getItem(position);
        viewHolder.name.setText(pojoDetails.getPizzaname());
        viewHolder.price.setText(pojoDetails.getPrice());
        viewHolder.quantity.setText(pojoDetails.getQuantuu());
        viewHolder.des.setText(pojoDetails.getDes());
        viewHolder.address.setText("Address-"+pojoDetails.getAddress());
        viewHolder.status.setText("Status-"+pojoDetails.getStatus());


        if(pojoDetails.getPizzaname().equals("Customised Pizza")){

            viewHolder.imagepiz.setImageResource(R.drawable.custo);
        }


        if (pojoDetails.getPizzaname().equals("Super Veggie Pizza"))
        {
            viewHolder.imagepiz.setImageResource(R.drawable.vegpizza);

        }

        if (pojoDetails.getPizzaname().equals("Hawaiian Pizza"))
        {
            viewHolder.imagepiz.setImageResource(R.drawable.hawa);
        }
        if (pojoDetails.getPizzaname().equals("Meat Pizza"))
        {
            viewHolder.imagepiz.setImageResource(R.drawable.meatpizza);
        }
        if (pojoDetails.getPizzaname().equals("BBQ Chicken Pizza"))
        {
            viewHolder.imagepiz.setImageResource(R.drawable.bbqchickenpizza);
        }
        if(pojoDetails.getPizzaname().equals("Pepporoni Pizza"))

        {
            viewHolder.imagepiz.setImageResource(R.drawable.pepporonipizza);
        }
        if(pojoDetails.getPizzaname().equals("Buffalo Pizza"))
        {
            viewHolder.imagepiz.setImageResource(R.drawable.buffalopizza);
        }

        if (pojoDetails.getPizzaname().equals("Margherita Pizza"))
        {
            viewHolder.imagepiz.setImageResource(R.drawable.margheritapizza);
        }

        if (pojoDetails.getPizzaname().equals("Supreme Pizza"))
        {
            viewHolder.imagepiz.setImageResource(R.drawable.supremepizza);
        }

        if (pojoDetails.getPizzaname().equals("Cheese Pizza"))
        {
            viewHolder.imagepiz.setImageResource(R.drawable.cheesepizza);
        }
        if(pojoDetails.getPizzaname().equals("Work Pizza")){

            viewHolder.imagepiz.setImageResource(R.drawable.workpizza);
        }
        if(pojoDetails.getPizzaname().equals("Verdugo Pizza")){

            viewHolder.imagepiz.setImageResource(R.drawable.verdugopizza);
        }
        if(pojoDetails.getPizzaname().equals("Mellow Mushroom")){

            viewHolder.imagepiz.setImageResource(R.drawable.mellowmushroom);
        }
        if(pojoDetails.getPizzaname().equals("Chicken Bites")){

            viewHolder.imagepiz.setImageResource(R.drawable.chicken_bites);
        }
        if(pojoDetails.getPizzaname().equals("Wing It Box")){

            viewHolder.imagepiz.setImageResource(R.drawable.wingit);
        }
        if(pojoDetails.getPizzaname().equals("Pizza With Fries")){

            viewHolder.imagepiz.setImageResource(R.drawable.pizzawithfires);
        }
        if(pojoDetails.getPizzaname().equals("2 Large Pizza With Drinks")){

            viewHolder.imagepiz.setImageResource(R.drawable.largepizzawithdrinks);
        }
        if(pojoDetails.getPizzaname().equals("Fries,Nuggets+Drinks")){

            viewHolder.imagepiz.setImageResource(R.drawable.friesnuggets);
        }
        if(pojoDetails.getPizzaname().equals("Pizza and Wings Deal")){

            viewHolder.imagepiz.setImageResource(R.drawable.pizzawithdippings);
        }
        if(pojoDetails.getPizzaname().equals("Flavoured Sparkling Water")){

            viewHolder.imagepiz.setImageResource(R.drawable.sparkling_water);
        }
        if(pojoDetails.getPizzaname().equals("Nestea")){

            viewHolder.imagepiz.setImageResource(R.drawable.nestea);
        }
        if(pojoDetails.getPizzaname().equals("Marble Brownies")){

            viewHolder.imagepiz.setImageResource(R.drawable.marblebrownies);
        }
        if(pojoDetails.getPizzaname().equals("Speciality Chicken")){

            viewHolder.imagepiz.setImageResource(R.drawable.speciality);
        }
        if(pojoDetails.getPizzaname().equals("Bottled Water")){

            viewHolder.imagepiz.setImageResource(R.drawable.water_bottle);
        }
        if(pojoDetails.getPizzaname().equals("Monster Original")){

            viewHolder.imagepiz.setImageResource(R.drawable.monster);
        }
        if(pojoDetails.getPizzaname().equals("Lava Cake")){

            viewHolder.imagepiz.setImageResource(R.drawable.lava);
        }
        if(pojoDetails.getPizzaname().equals("Chicken Wings")){

            viewHolder.imagepiz.setImageResource(R.drawable.chickenwingsss);
        }
        if(pojoDetails.getPizzaname().equals("Can Pop")){

            viewHolder.imagepiz.setImageResource(R.drawable.coke_tin);
        }
        if(pojoDetails.getPizzaname().equals("Bottle Pop")){

            viewHolder.imagepiz.setImageResource(R.drawable.bottle_coke);
        }
        if(pojoDetails.getPizzaname().equals("French Fries")){

            viewHolder.imagepiz.setImageResource(R.drawable.fries);
        }
        if(pojoDetails.getPizzaname().equals("Supreme Energetic Poutine")){

            viewHolder.imagepiz.setImageResource(R.drawable.poutine);
        }




        // Double pricuu= Double.valueOf(pojoDetails.getPrice());
        //  Double pricuu=0.0;
        // Double xyz= Double.parseDouble( viewHolder.price.getText().toString());



        return convertView;
    }

    class ViewHolder{
        TextView name,price,quantity,des,status,address;
        ImageView imagepiz;

        public ViewHolder(View view)
        {
            status=view.findViewById(R.id.status);
            address=view.findViewById(R.id.address);
            name=view.findViewById(R.id.pizza_name);
            price=view.findViewById(R.id.pizza_price);
            des=view.findViewById(R.id.pizza_des);
            imagepiz=view.findViewById(R.id.imagepiz);
            quantity=view.findViewById(R.id.pizza_quantity);
        }
    }


}



