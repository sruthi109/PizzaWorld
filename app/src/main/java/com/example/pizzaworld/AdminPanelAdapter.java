package com.example.pizzaworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pizzaworld.model.PojoDetails;

import java.util.List;

public class AdminPanelAdapter extends BaseAdapter {
    List<PojoDetails> pojoDetails;
    Context context;

    public AdminPanelAdapter(Context context, List<PojoDetails> pojoDetails) {
        super();
        this.pojoDetails = pojoDetails;
        this.context = context;

    }

    @Override
    public int getCount() {
        return pojoDetails.size();
    }

    @Override
    public PojoDetails getItem(int position) {
        return pojoDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdminPanelAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adminpanel, null);
            viewHolder = new AdminPanelAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AdminPanelAdapter.ViewHolder) convertView.getTag();
            //PojoDetails pojoDetails=getItem(position);

        }
        PojoDetails pojoDetails = getItem(position);
        viewHolder.user.setText(pojoDetails.getUserId());
        return convertView;
    }



    class ViewHolder {
        TextView user;

        //
        public ViewHolder(View view)
        {
            user=view.findViewById(R.id.username);

        }
    }
}
