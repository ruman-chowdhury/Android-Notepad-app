package com.example.user.notepad;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER-PC on 5/23/2018.
 */

public class CustomAdapter extends ArrayAdapter<TempData>{

   ArrayList<TempData> datalist;
    Context context;

    public CustomAdapter(Context context, ArrayList<TempData> datalist) {
        super(context,R.layout.custom_list,datalist);
        this.datalist=datalist;
        this.context=context;

    }


    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {


        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list, parent, false);

        }

        TextView tvTitle = convertView.findViewById(R.id.idTitle);
        TextView tvDes = convertView.findViewById(R.id.idDes);

//        tvTitle.setText(datalist[position]);
//        tvDes.setText(datalist[position]);

        tvTitle.setText(datalist.get(position).getTitle());
        tvDes.setText(datalist.get(position).getDescription());

        return convertView;
    }


}
