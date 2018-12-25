package com.example.moham.portfolio_2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<Recipe> recipeList;

    public CustomAdapter( Context context, int resource,ArrayList<Recipe> recipeList) {
        super(context, resource, recipeList);
        this.context = context;
        this.resource = resource;
        this.recipeList = recipeList;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @Nullable ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,null,false);

        TextView tvName = view.findViewById(R.id.textTitle);
        ImageView iv1 = view.findViewById(R.id.imageViewFood);
        ImageView iv2 = view.findViewById(R.id.imageViewrECIPE);

        Recipe current = recipeList.get(position);
        tvName.setText(current.getName());
        iv1.setImageResource(current.getImage());
        iv2.setImageResource(R.drawable.arrow);

        int checkEven = position + 1;
        if(checkEven % 2 == 0){
            tvName.setBackgroundColor(Color.parseColor("#ffffff"));
            iv1.setBackgroundColor(Color.parseColor("#ffffff"));
            iv2.setBackgroundColor(Color.parseColor("#ffffff"));
            tvName.setTextColor(Color.parseColor("#008577"));
        }



        return view;

    }
}
