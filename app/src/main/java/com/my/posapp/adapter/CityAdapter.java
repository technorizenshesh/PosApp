package com.my.posapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.posapp.R;
import com.my.posapp.model.CityModel;
import com.my.posapp.model.GetStaterModel;

import java.util.ArrayList;

public class CityAdapter extends BaseAdapter {

    Context context;
    int flags[];

    String[] countryNames;
    LayoutInflater inflter;
    TextView countrycode;
    ImageView icon;
    ArrayList<CityModel.Result> modelListCity;

    public CityAdapter(Context applicationContext, int[] flags, ArrayList<CityModel.Result> code) {
        this.context = applicationContext;
        this.flags = flags;
        this.modelListCity = code;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return modelListCity.size();
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
        view = inflter.inflate(R.layout.spinner_state, null);
        //icon = (ImageView) view.findViewById(R.id.img_flag);
       countrycode = (TextView) view.findViewById(R.id.textview);
        // icon.setImageResource(flags[i]);
      //countrycode.setText(code[i]);
       countrycode.setText(modelListCity.get(i).getName());

        return view;

    }
}

