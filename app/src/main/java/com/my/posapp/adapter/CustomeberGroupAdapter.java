package com.my.posapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.posapp.R;
import com.my.posapp.model.GetCustomerGroup;

import java.util.ArrayList;

public class CustomeberGroupAdapter extends BaseAdapter {

    Context context;
    int flags[];

    String[] countryNames;
    LayoutInflater inflter;
    TextView countrycode;
    ImageView icon;
    ArrayList<GetCustomerGroup.Result> code;

    public CustomeberGroupAdapter(Context applicationContext, int[] flags, ArrayList<GetCustomerGroup.Result> code) {
        this.context = applicationContext;
        this.flags = flags;
        this.code = code;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return code.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_layout_one, null);
        //icon = (ImageView) view.findViewById(R.id.img_flag);
       countrycode = (TextView) view.findViewById(R.id.textview);
        // icon.setImageResource(flags[i]);
      //countrycode.setText(code[i]);
       countrycode.setText(code.get(i).getName());

        return view;

    }
}

